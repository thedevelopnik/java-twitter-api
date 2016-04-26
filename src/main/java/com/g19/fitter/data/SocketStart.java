package com.g19.fitter.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.session.web.socket.events.SessionConnectEvent;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.Map;

/*
 * Created by davidsudia on 4/22/16.
 */
@Component
public class SocketStart {

    @Inject
    private Twitter twitter;

    private TweetsService tweetsService;

    private StompConnectEvent connectEvent;

    @Autowired
    public SocketStart(
            TweetsService tweetsService,
            StompConnectEvent connectEvent) throws InterruptedException {
        this.tweetsService = tweetsService;
        this.connectEvent = connectEvent;
        tweetsService.streamApi();
    }


}
