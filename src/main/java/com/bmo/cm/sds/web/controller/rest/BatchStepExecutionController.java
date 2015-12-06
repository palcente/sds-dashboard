package com.bmo.cm.sds.web.controller.rest;

import com.bmo.cm.sds.web.dao.BatchJobExecutionDao;
import com.bmo.cm.sds.web.dao.BatchStepExecutionDao;
import com.bmo.cm.sds.web.model.BatchStepExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by matt on 06/12/2015.
 */

@RestController
public class BatchStepExecutionController {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private BatchStepExecutionDao dao;

    @RequestMapping(value = "/batchStepExecution", method = RequestMethod.GET)
    public List<BatchStepExecution> getStepsPerExecution(@RequestParam(name="jobExecutionId") long id) {
        return dao.findStepsByjobExecutionId(id);
    }

}
