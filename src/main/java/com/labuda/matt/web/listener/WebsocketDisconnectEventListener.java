package com.labuda.matt.web.listener;


import com.labuda.matt.web.util.websocket.WebsocketSessionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

/**
 * Created by matt on 06/12/2015.
 * Intercepts disconnect events on the websocket
 */

@Component
public class WebsocketDisconnectEventListener implements ApplicationListener<SessionDisconnectEvent> {

    private static Logger logger = LoggerFactory.getLogger(WebsocketDisconnectEventListener.class);


    @Autowired
private WebsocketSessionContext websocketSessionContext;

    @Override
    public void onApplicationEvent(SessionDisconnectEvent sessionDisconnectEvent) {
        String simpSessionId = (String) sessionDisconnectEvent.getMessage().getHeaders().get("simpSessionId");
        logger.debug("Deregistering session : {}", simpSessionId);
        websocketSessionContext.deregisterSession(simpSessionId);
    }
}
