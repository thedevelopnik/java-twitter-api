package com.g19.fitter;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

/*
 * Created by davidsudia on 4/26/16.
 */
public class SocketHandler implements WebSocketHandler {
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {

    }

    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {

    }

    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {

    }

    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {

    }

    public boolean supportsPartialMessages() {
        return false;
    }
}
