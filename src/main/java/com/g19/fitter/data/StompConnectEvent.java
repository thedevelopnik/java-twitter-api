package com.g19.fitter.data;

import org.springframework.context.ApplicationListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;

import javax.inject.Inject;
import java.util.List;

/*
 * Created by davidsudia on 4/26/16.
 */
@Component
class StompConnectEvent implements ApplicationListener<SessionConnectEvent> {

    @Inject
    private TweetsService tweetsService;

    public void onApplicationEvent(SessionConnectEvent event) {
        Message message = event.getMessage();
        StompHeaderAccessor headers = StompHeaderAccessor.wrap(message);
        List<String> apiKey = headers.getNativeHeader("apiKey");
        String apiKeyStr = apiKey.get(0);
        List<String> keywords = headers.getNativeHeader("keywords");
        List<String> semantic = headers.getNativeHeader("semantic");
        tweetsService.setFilter(apiKeyStr, keywords, true);
        try {
            tweetsService.streamApi();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
