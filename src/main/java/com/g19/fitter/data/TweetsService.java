package com.g19.fitter.data;

import org.springframework.social.twitter.api.*;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

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

    public ModelMap streamApi(final ModelMap modelMap) throws InterruptedException {

        final BlockingQueue<Tweet> tweets = new ArrayBlockingQueue<Tweet>(20);

        List<StreamListener> listeners = new ArrayList<StreamListener>();
        StreamListener streamListener = new StreamListener() {
            public void onTweet(Tweet tweet) {
                tweets.add(tweet);
                modelMap.put("tweets", tweets);
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

        return modelMap;
    }
}