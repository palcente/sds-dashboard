package com.labuda.matt.web.listener;


import com.labuda.matt.web.util.websocket.WebsocketSessionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;

/**
 * Created by matt on 06/12/2015.
 * Intercepts connect events on the websocket
 */

@Component
public class WebsocketConnectEventListener implements ApplicationListener<SessionConnectedEvent> {

    private static Logger logger = LoggerFactory.getLogger(WebsocketConnectEventListener.class);


    @Autowired
    private WebsocketSessionContext websocketSessionContext;

    @Override
    public void onApplicationEvent(SessionConnectedEvent sessionConnectEvent) {
        String simpSessionId = (String) sessionConnectEvent.getMessage().getHeaders().get("simpSessionId");
        logger.debug("Registering session : {}", simpSessionId);
        websocketSessionContext.registerSession(simpSessionId);
    }
}
