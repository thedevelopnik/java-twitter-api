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

    @Autowired
    public TweetsService(
            final MessageSendingOperations<String> messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }


    @SuppressWarnings("unchecked")
    void streamApi(final String apiKey, final List<String> keywords) throws InterruptedException {

        List<StreamListener> listeners = new ArrayList<StreamListener>();

        StreamListener streamListener = new StreamListener() {
            public void onTweet(Tweet tweet) {
                String destination = "/tweets";
                String languageCode = tweet.getLanguageCode();
                if (languageCode.equals(localLang)) {
                    String id = tweet.getIdStr();
                    String text = tweet.getText();
                    String user = tweet.getFromUser();
                    String profileImg = tweet.getProfileImageUrl();
                    MinTweet minTweet;
                    if (!keywords.isEmpty()) {
                        if (text.contains(keywords.get(0))) {
                            if (tweet.hasMedia()) {
                                Entities entities = tweet.getEntities();
                                List<MediaEntity> media = entities.getMedia();
                                String mediaType = media.get(0).getType();
                                String mediaUrl = media.get(0).getMediaSecureUrl();
                                minTweet = new MinTweet(id, text, user, profileImg, mediaType, mediaUrl);
                            } else {
                                minTweet = new MinTweet(id, text, user, profileImg, null, null);
                            }
                            messagingTemplate.convertAndSend(destination, minTweet);
                        }
                    } else {
                        if (tweet.hasMedia()) {
                            Entities entities = tweet.getEntities();
                            List<MediaEntity> media = entities.getMedia();
                            String mediaType = media.get(0).getType();
                            String mediaUrl = media.get(0).getMediaSecureUrl();
                            minTweet = new MinTweet(id, text, user, profileImg, mediaType, mediaUrl);
                        } else {
                            minTweet = new MinTweet(id, text, user, profileImg, null, null);
                        }
                        messagingTemplate.convertAndSend(destination, minTweet);
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

}