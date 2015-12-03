package com.bmo.cm.sds.web.controller;

import com.bmo.cm.sds.web.dao.BatchJobInstanceDao;
import com.bmo.cm.sds.web.model.BatchJobInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import javax.sql.DataSource;

@Controller
public class GreetingController {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private DataSource ds;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private BatchJobInstanceDao dao;



    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public BatchJobInstance greeting(HelloMessage message) throws Exception {
        return dao.findOne(message.getName());
    }

}
