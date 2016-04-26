package com.g19.fitter.controller;

import com.g19.fitter.data.TweetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.core.MessageSendingOperations;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;


/*
* Created by davidsudia on 4/22/16.
*/
@Controller
public class ApiRequestController {

    private TwitterTemplate twitterTemplate;

    private TweetsService tweetsService;

    @Autowired
    public ApiRequestController(
            TweetsService tweetsService,
            TwitterTemplate twitterTemplate) throws InterruptedException {
        this.tweetsService = tweetsService;
        this.twitterTemplate = twitterTemplate;
        tweetsService.streamApi();
    }
}

