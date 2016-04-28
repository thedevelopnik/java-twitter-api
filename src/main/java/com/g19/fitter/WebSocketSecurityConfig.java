package com.g19.fitter;

import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.security.config.annotation.web.messaging.MessageSecurityMetadataSourceRegistry;
import org.springframework.security.config.annotation.web.socket.AbstractSecurityWebSocketMessageBrokerConfigurer;

/*
 * Created by davidsudia on 4/28/16.
 */
public class WebSocketSecurityConfig extends AbstractSecurityWebSocketMessageBrokerConfigurer {
    public void configureInbound(MessageSecurityMetadataSourceRegistry messages) {
        messages
                .nullDestMatcher().permitAll()
                .simpTypeMatchers(SimpMessageType.CONNECT, SimpMessageType.DISCONNECT, SimpMessageType.SUBSCRIBE, SimpMessageType.HEARTBEAT, SimpMessageType.MESSAGE)
                .permitAll()
                .simpSubscribeDestMatchers("/tweets/*").permitAll()
                .simpDestMatchers("/tweets").permitAll()
                .anyMessage().permitAll();
    }
}
