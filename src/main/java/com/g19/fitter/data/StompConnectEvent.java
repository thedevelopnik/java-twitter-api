package com.g19.fitter.data;

import org.springframework.context.ApplicationListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.NativeMessageHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;

import java.util.List;
import java.util.Map;

/*
 * Created by davidsudia on 4/26/16.
 */
@Component
class StompConnectEvent implements ApplicationListener<SessionConnectEvent> {

    public void onApplicationEvent(SessionConnectEvent event) {
        Message message = event.getMessage();
        StompHeaderAccessor wrap = StompHeaderAccessor.wrap(message);
//        StompHeaderAccessor wrap = StompHeaderAccessor.wrap(message);
//        MessageHeaders messageHeaders = wrap.getMessageHeaders();
//        Object nativeHeaders = messageHeaders.get("nativeHeaders");
//        System.out.println(nativeHeaders);
    }
}
