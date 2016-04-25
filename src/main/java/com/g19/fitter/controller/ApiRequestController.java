//package com.g19.fitter.controller;
//
//import com.g19.fitter.data.TweetFilter;
//import com.g19.fitter.model.Tweet;
//import org.springframework.social.twitter.api.Twitter;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//import com.g19.fitter.data.TweetsService;
//
//import javax.inject.Inject;
//import java.util.concurrent.BlockingQueue;
//
///**
// * Created by davidsudia on 4/22/16.
// */
//@Controller
//public class ApiRequestController {
//
//    private final Twitter twitter;
//
//    @Inject
//    public ApiRequestController(Twitter twitter) {
//        this.twitter = twitter;
//    }
//
//    @RequestMapping(value="/")
//    public String streamTweet(ModelMap modelMap) {
//        return "tweets";
//    }
//
//}
//
