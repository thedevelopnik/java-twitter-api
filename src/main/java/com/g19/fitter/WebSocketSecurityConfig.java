package com.g19.fitter;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.security.config.annotation.web.messaging.MessageSecurityMetadataSourceRegistry;
import org.springframework.security.config.annotation.web.socket.AbstractSecurityWebSocketMessageBrokerConfigurer;


/*
 * Created by davidsudia on 4/28/16.
 */

@Configuration
public class WebSocketSecurityConfig extends AbstractSecurityWebSocketMessageBrokerConfigurer {

    public void configureInbound(MessageSecurityMetadataSourceRegistry messages) {
        messages
                .nullDestMatcher().permitAll()
                .simpTypeMatchers(SimpMessageType.CONNECT, SimpMessageType.DISCONNECT, SimpMessageType.HEARTBEAT, SimpMessageType.MESSAGE, SimpMessageType.SUBSCRIBE).permitAll()
                .simpSubscribeDestMatchers("/tweets/*").permitAll()
                .simpDestMatchers("/tweets").permitAll()
                .anyMessage().permitAll();
    }
}