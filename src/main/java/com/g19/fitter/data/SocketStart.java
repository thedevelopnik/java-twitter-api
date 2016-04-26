package com.g19.fitter.data;

import com.g19.fitter.data.TweetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.inject.Inject;

/**
 * Created by davidsudia on 4/22/16.
 */
@Component
public class SocketStart {

    @Inject
    private Twitter twitter;

    private TweetsService tweetsService;

    @Autowired
    public SocketStart(
            TweetsService tweetsService) throws InterruptedException {
        this.tweetsService = tweetsService;
        tweetsService.streamApi();
    }
}
