package com.g19.fitter.data;

import com.g19.fitter.model.MinTweet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.core.MessageSendingOperations;
import org.springframework.social.twitter.api.*;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.*;

/*
 * Created by davidsudia on 4/18/16.
 */
@Service
class TweetsService {

    @Inject
    private Twitter twitter;

    private final MessageSendingOperations messagingTemplate;

    private String localLang = "en";

    private Filterer filterer;

    @Autowired
    public TweetsService(
            final MessageSendingOperations<String> messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
        filterer = new Filterer();
    }

    public void setFilter(String apiKey, List<String> keyWords) {
        filterer.addOrReplaceFilter(apiKey, keyWords);
    }

    @SuppressWarnings("unchecked")
    void streamApi() throws InterruptedException {

        List<StreamListener> listeners = new ArrayList<StreamListener>();

        StreamListener streamListener = new StreamListener() {
            int count = 0;
            public void onTweet(Tweet tweet) {
                count++;
                String destination = "/tweets";
                String languageCode = tweet.getLanguageCode();
                if (languageCode.equals(localLang)) {
                    String id = String.valueOf(count);
                    String text = tweet.getText();
                    String user = tweet.getFromUser();
                    String profileImg = tweet.getProfileImageUrl();
                    MinTweet minTweet;
                    if (tweet.hasMedia()) {
                        Entities entities = tweet.getEntities();
                        List<MediaEntity> media = entities.getMedia();
                        String mediaType = media.get(0).getType();
                        String mediaUrl = media.get(0).getMediaSecureUrl();
                        minTweet = new MinTweet(id, text, user, profileImg, mediaType, mediaUrl);
                    } else {
                        minTweet = new MinTweet(id, text, user, profileImg, null, null);
                    }
                    ArrayList<String> endpoints = filterer.processTweet(tweet);
                    for (String endpoint : endpoints) {
                        messagingTemplate.convertAndSend(destination + "/" + endpoint, minTweet);
                    }
                }
            }

            public void onDelete(StreamDeleteEvent deleteEvent) {
            }

            public void onLimit(int numberOfLimitedTweets) {
            }

            public void onWarning(StreamWarningEvent warningEvent) {
            }
        };

        listeners.add(streamListener);

        Stream stream = twitter.streamingOperations().sample(listeners);
    }
    private class Filterer {
        private HashMap<String, List<String>> filterMap;
        Filterer() {
            filterMap = new HashMap<String, List<String>>();
        }
        public void addOrReplaceFilter(String apiKey, List<String> keyWords) {
            filterMap.put(apiKey, keyWords);
        }
        public void removeFilter(String apiKey) {
            filterMap.remove(apiKey);
        }
        public ArrayList<String> processTweet(Tweet tweet) {
            ArrayList<String> temp = new ArrayList<String>();
            for(String apiKey : filterMap.keySet()) {
                for (String word : filterMap.get(apiKey)) {
                    if (tweet.getText().contains(word)) {
                        temp.add(apiKey);
                    }
                }
            }
            return temp;
         }
    }

}