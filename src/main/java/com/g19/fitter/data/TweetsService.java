package com.g19.fitter.data;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.social.twitter.api.*;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by davidsudia on 4/18/16.
 */
@Service
public class TweetsService implements StreamListener {

    @Inject
    private Twitter twitter;
    @Inject
    private ThreadPoolTaskExecutor taskExecutor;
    @Value("${twitterProcessing.enabled}")
    private boolean processingEnabled;

    private BlockingQueue<Tweet> queue = new ArrayBlockingQueue<Tweet>(20);

    public void run() {
        List<StreamListener> listeners = new ArrayList<StreamListener>();
        listeners.add(this);
        twitter.streamingOperations().sample(listeners);
    }

    @PostConstruct
    public void afterPropertiesSet() {
        if (processingEnabled) {
            for (int i = 0; i < taskExecutor.getMaxPoolSize(); i++) {
                taskExecutor.execute(new TweetFilter(queue));
            }
        }

        run();
    }

    public void onTweet(Tweet tweet) {
        System.out.println("There was a tweet!");
        queue.offer(tweet);
    }

    public void onDelete(StreamDeleteEvent deleteEvent) {
        System.out.println("I have just the thing for you! BALEETED!");
    }

    public void onLimit(int numberOfLimitedTweets) {
        System.out.println("You've reached your limit! I'm cutting you off!");
    }

    public void onWarning(StreamWarningEvent warningEvent) {
        System.out.println("Warning! Danger Will Robinson!");
    }

}
