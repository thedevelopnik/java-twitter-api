package com.g19.fitter.data;

import org.springframework.social.twitter.api.Tweet;

import java.util.concurrent.BlockingQueue;

/**
 * Created by davidsudia on 4/15/16.
 */
public class TweetFilter implements Runnable {
    private final BlockingQueue<Tweet> queue;

    public TweetFilter(BlockingQueue<Tweet> queue) {
        this.queue = queue;
    }

    public void run() {
        while (true) {
            try {
                Tweet tweet = queue.take();
                filterTweet(tweet);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void filterTweet(Tweet tweetEntity) {
        System.out.println(tweetEntity);
    }

}
