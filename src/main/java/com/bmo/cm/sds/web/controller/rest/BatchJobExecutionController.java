package com.bmo.cm.sds.web.controller.rest;

import com.bmo.cm.sds.web.dao.BatchJobExecutionDao;
import com.bmo.cm.sds.web.model.BatchJobExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by matt on 05/12/2015.
 */


@RestController
public class BatchJobExecutionController {

@SuppressWarnings("SpringJavaAutowiringInspection")
@Autowired
private BatchJobExecutionDao dao;

    @RequestMapping(value = "/batchJobExecution", method = RequestMethod.GET)
    public BatchJobExecution getJobExecution(@RequestParam(name="id") long id) {
        return dao.findOne(id);
    }
}
