package com.bmo.cm.sds.web.controller;

import com.bmo.cm.sds.web.dao.BatchJobInstanceDao;
import com.bmo.cm.sds.web.dao.DashboardDao;
import com.bmo.cm.sds.web.model.BatchJobInstance;
import com.bmo.cm.sds.web.model.DashboardEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

/**
 * Created by matt on 29/11/2015.
 */
@Controller
public class DashboardController {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private DashboardDao dao;

    @MessageMapping("/dashboard")
    @SendTo("/topic/dashboardEntries")
    public List<DashboardEntry> pushEntries(HelloMessage m) throws Exception {
        //return dao.getDashboardEntriesByDate(Date.valueOf(m.getDate()));
        System.out.println(m.getDate());
        return dao.findByFromDateBetween(Date.valueOf(m.getDate()), Date.valueOf(Date.valueOf(m.getDate()).toLocalDate().plusDays(1)));
    }
}
