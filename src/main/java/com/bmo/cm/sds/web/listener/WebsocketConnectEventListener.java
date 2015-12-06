package com.bmo.cm.sds.web.listener;


import com.bmo.cm.sds.web.util.websocket.WebsocketSessionContext;
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

    @Autowired
    private WebsocketSessionContext websocketSessionContext;

    @Override
    public void onApplicationEvent(SessionConnectedEvent sessionConnectEvent) {
        String simpSessionId = (String) sessionConnectEvent.getMessage().getHeaders().get("simpSessionId");
        websocketSessionContext.registerSession(simpSessionId);
    }
}
