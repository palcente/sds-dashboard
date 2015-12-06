package com.bmo.cm.sds.web.listener;


import com.bmo.cm.sds.web.util.websocket.WebsocketSessionContext;
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

@Autowired
private WebsocketSessionContext websocketSessionContext;

    @Override
    public void onApplicationEvent(SessionDisconnectEvent sessionDisconnectEvent) {
        String simpSessionId = (String) sessionDisconnectEvent.getMessage().getHeaders().get("simpSessionId");
        websocketSessionContext.deregisterSession(simpSessionId);
    }
}
