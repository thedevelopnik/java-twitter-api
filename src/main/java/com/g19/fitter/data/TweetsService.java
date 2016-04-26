package com.g19.fitter.data;

import org.springframework.social.twitter.api.*;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by davidsudia on 4/18/16.
 */
@Service
public class TweetsService {

    @Inject
    private Twitter twitter;

    public BlockingQueue<Tweet> streamApi() throws InterruptedException {

        final BlockingQueue<Tweet> tweets = new ArrayBlockingQueue<Tweet>(20);

        List<StreamListener> listeners = new ArrayList<StreamListener>();
        StreamListener streamListener = new StreamListener() {
            public void onTweet(Tweet tweet) {
                tweets.add(tweet);
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

        if (tweets.isEmpty()) {
            Thread.sleep(3000);
        }
        return tweets;

    }
}