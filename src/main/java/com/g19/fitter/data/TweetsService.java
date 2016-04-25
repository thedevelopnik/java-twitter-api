package com.g19.fitter.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by davidsudia on 4/18/16.
 */
@Service
public class TweetsService {
    @Autowired
    private Twitter twitter;

    public List<Tweet> streamApi(String param1) {
        final List<Tweet> tweets = new ArrayList<Tweet>();

        List<StreamListener> listeners = new ArrayList<StreamListener>();
        StreamListener streamListener = new StreamListener() {
            public void onTweet(org.springframework.social.twitter.api.Tweet tweet) {
                System.out.println(tweet);
                tweets.add(tweet);
            }

            public void onDelete(StreamDeleteEvent deleteEvent) {
                System.out.println(deleteEvent);
            }

            public void onLimit(int numberOfLimitedTweets) {
                System.out.println(numberOfLimitedTweets);
            }

            public void onWarning(StreamWarningEvent warningEvent) {
                System.out.println(warningEvent);
            }
        };

        listeners.add(streamListener);

        Stream firehose = twitter.streamingOperations().firehose(listeners);

        return tweets;
    }

}
