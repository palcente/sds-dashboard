package com.labuda.matt.web.controller.websocket;

import com.labuda.matt.web.dao.DashboardDao;
import com.labuda.matt.web.model.DashboardEntry;
import com.labuda.matt.web.model.WebsocketMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Created by matt on 29/11/2015.
 * TODO:Refine query returning dashboard entries, perhaps we could fetch entries 12/24/36/48 hours back.
 * TODO:Quick workaround to save the state here, which probably is not good... until above is fixed at least.
 */
@Controller
public class DashboardController {

    DateTimeFormatter dTF = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    WebsocketMessage lastMessage;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private DashboardDao dao;

    @MessageMapping("/dashboard")
    @SendTo("/topic/dashboardEntries")
    public List<DashboardEntry> pushEntries(WebsocketMessage m) throws Exception {
        setLastMessage(m);
        return dao.findByFromDateBetween(LocalDate.parse(m.getDate(),dTF).atStartOfDay(), LocalDate.parse(m.getDate(),dTF).plusDays(1).atStartOfDay());
    }

    public WebsocketMessage getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(WebsocketMessage lastMessage) {
        this.lastMessage = lastMessage;
    }
}
