package com.g19.fitter.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/*
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
