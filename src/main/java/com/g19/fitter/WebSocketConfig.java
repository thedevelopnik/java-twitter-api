package com.g19.fitter;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.handler.invocation.HandlerMethodArgumentResolver;
import org.springframework.messaging.handler.invocation.HandlerMethodReturnValueHandler;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;

import java.util.List;

/*
 * Created by davidsudia on 4/25/16.
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/tweet").withSockJS();
    }

    public void configureWebSocketTransport(WebSocketTransportRegistration registry) {

    }

    public void configureClientInboundChannel(ChannelRegistration registration) {

    }

    public void configureClientOutboundChannel(ChannelRegistration registration) {

    }

    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {

    }

    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {

    }

    public boolean configureMessageConverters(List<MessageConverter> messageConverters) {
        return false;
    }

    public void configureMessageBroker(MessageBrokerRegistry registry) {

    }
}
