package com.g19.fitter.controller;

import com.g19.fitter.data.TweetsService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;


/**
 * Created by davidsudia on 4/22/16.
 */
@Controller
public class ApiRequestController {

    private TwitterTemplate twitterTemplate;

    private TweetsService tweetsService;

    @Inject
    public ApiRequestController(TweetsService tweetsService, TwitterTemplate twitterTemplate) {
        this.tweetsService = tweetsService;
        this.twitterTemplate = twitterTemplate;
    }

    @MessageMapping("/tweets")
    @SendTo("/topic/tweet")
    public String streamTweet(String message) throws Exception {
        System.out.println(message);
        BlockingQueue<Tweet> queue = tweetsService.streamApi();
        Tweet tweet = queue.take();
        System.out.println(queue);
        System.out.println(tweet.getText());
        return tweet.getText();
    }

}

