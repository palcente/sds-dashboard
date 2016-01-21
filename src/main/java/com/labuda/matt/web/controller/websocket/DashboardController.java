package com.labuda.matt.web.controller.websocket;

import com.labuda.matt.web.dao.DashboardDao;
import com.labuda.matt.web.model.DashboardEntry;
import com.labuda.matt.web.model.WebsocketMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Created by matt on 29/11/2015.
 * TODO:Refine query returning dashboard entries, perhaps we could fetch entries 12/24/36/48 hours back.
 * TODO:Quick workaround to save the state here, which probably is not good... until above is fixed at least.
 */
@Controller
public class DashboardController {

    private static Logger logger = LoggerFactory.getLogger(DashboardController.class);

    @Autowired
    private SimpMessagingTemplate template;

    @Autowired
    private DashboardDao dao;

    private List<DashboardEntry> cache;

    @MessageMapping("/dashboard")
    @SendTo("/topic/dashboardEntries")
    public List<DashboardEntry> pushFreshEntries() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime yesterday = now.minusHours(24);
        this.cache = dao.findByFromDateBetween(yesterday,now);
        this.template.convertAndSend("/topic/dashboardEntries", cache);
        logger.info("Pushing fresh list of dashboard entries");
        return cache;
    }

    @SendTo("/topic/dashboardEntries")
    public List<DashboardEntry> pushCachedEntries() {
        logger.info("Caching fresh list of dashboard entries");
        this.template.convertAndSend("/topic/dashboardEntries", cache);
        return cache;
    }
}
