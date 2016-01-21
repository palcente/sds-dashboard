package com.labuda.matt.web.util.websocket;

import com.labuda.matt.web.controller.websocket.DashboardController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Created by matt on 06/12/2015.
 * TODO=I'm sure there is better way to do this. It works tho..
 */
@Component
public class DashboardEntryPoller {

    private static Logger logger = LoggerFactory.getLogger(DashboardEntryPoller.class);

    public static LocalDateTime LAST_UPDATE_DATETIME;

    @Autowired
    WebsocketSessionContext websocketSessionContext;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private JdbcTemplate template;
    @Autowired
    private DashboardController dashboardController;


    private String SQL = "SELECT MAX(LAST_UPDATED) FROM BATCH_JOB_EXECUTION";

    @Scheduled(initialDelay = 1000, fixedDelayString = "${pollingDelay.in.milliseconds}")
    private void pollDashboardEntries() throws Exception {

        if(websocketSessionContext.hasActiveSessions()) {

            LocalDateTime lastUpdated = template.queryForObject(SQL, Timestamp.class).toLocalDateTime();

            if (LAST_UPDATE_DATETIME == null)
                LAST_UPDATE_DATETIME = lastUpdated;

            if (lastUpdated.isAfter(LAST_UPDATE_DATETIME)) {
                LAST_UPDATE_DATETIME = lastUpdated;
                dashboardController.pushFreshEntries();
            } else {
                dashboardController.pushCachedEntries();
            }
        }

    }

}
