package com.g19.fitter.controller;

import com.g19.fitter.data.TweetsService;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;


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

    @RequestMapping(value = "/")
    public String streamTweet(ModelMap modelMap) throws InterruptedException {
        ModelMap returnedModelMap = tweetsService.streamApi(modelMap);
        modelMap = returnedModelMap;
        System.out.println(returnedModelMap);
        return "tweets";
    }

}

