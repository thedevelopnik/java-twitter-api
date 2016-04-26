package com.g19.fitter.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.core.MessageSendingOperations;
import org.springframework.social.twitter.api.*;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.*;

/**
 * Created by davidsudia on 4/18/16.
 */
@Service
public class TweetsService {

    @Inject
    private Twitter twitter;

    private final MessageSendingOperations messagingTemplate;

    @Autowired
    public TweetsService(
            final MessageSendingOperations<String> messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void streamApi() throws InterruptedException {

        List<StreamListener> listeners = new ArrayList<StreamListener>();
        StreamListener streamListener = new StreamListener() {
            public void onTweet(Tweet tweet) {
                String destination = "/tweets";
                messagingTemplate.convertAndSend(destination, tweet.getText());
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