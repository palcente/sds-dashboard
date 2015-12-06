package com.bmo.cm.sds.web.controller.rest;

import com.bmo.cm.sds.web.dao.BatchJobExecutionDao;
import com.bmo.cm.sds.web.dao.BatchStepExecutionDao;
import com.bmo.cm.sds.web.model.BatchStepExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by matt on 06/12/2015.
 */

@RestController
public class BatchStepExecutionController {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private BatchStepExecutionDao dao;

    @RequestMapping(path ="/batchStepExecution/{jobExecutionId}", method = RequestMethod.GET)
    public List<BatchStepExecution> getStepsPerExecution(@PathVariable long jobExecutionId) {
        return dao.findStepsByjobExecutionId(jobExecutionId);
    }

}
