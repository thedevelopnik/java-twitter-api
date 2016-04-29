//package com.g19.fitter;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.messaging.simp.SimpMessageType;
//import org.springframework.security.config.annotation.web.messaging.MessageSecurityMetadataSourceRegistry;
//import org.springframework.security.config.annotation.web.socket.AbstractSecurityWebSocketMessageBrokerConfigurer;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.socket.config.annotation.EnableWebSocket;
//import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
//
///*
// * Created by davidsudia on 4/28/16.
// */
//@Configuration
//public class WebSocketSecurityConfig extends AbstractSecurityWebSocketMessageBrokerConfigurer {
//
//    public void registerStompEndpoints(StompEndpointRegistry registry) {
//        registry.addEndpoint("/tweet").setAllowedOrigins("*").withSockJS();
//    }
//
//    @Override
//    protected void configureInbound(MessageSecurityMetadataSourceRegistry messages) {
//        messages
//                .simpSubscribeDestMatchers("http://lvh.me/**/*").permitAll()
//                .simpDestMatchers("http://lvh.me/*").permitAll()
//                .simpTypeMatchers(SimpMessageType.MESSAGE,
//                        SimpMessageType.HEARTBEAT,
//                        SimpMessageType.CONNECT,
//                        SimpMessageType.DISCONNECT,
//                        SimpMessageType.SUBSCRIBE,
//                        SimpMessageType.UNSUBSCRIBE,
//                        SimpMessageType.OTHER).permitAll()
//                .anyMessage().permitAll();
//    }
//
//    @Override
//    protected boolean sameOriginDisabled() {
//        return true;
//    }
//}
