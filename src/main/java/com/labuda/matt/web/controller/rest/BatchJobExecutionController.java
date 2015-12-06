package com.labuda.matt.web.controller.rest;

import com.labuda.matt.web.dao.BatchJobExecutionDao;
import com.labuda.matt.web.model.BatchJobExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

/**
 * Created by matt on 05/12/2015.
 */


@RestController
public class BatchJobExecutionController {

    private static Logger logger = LoggerFactory.getLogger(BatchJobExecutionController.class);


    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private BatchJobExecutionDao dao;

    @Cacheable(cacheNames = "batchJobExecution",
            unless = "#result.status=='STARTED'  || " +
                    "#result.status=='STARTING' || " +
                    "#result.status=='STOPPING' || " +
                    "#result.status=='UNKNOWN'")
    @RequestMapping(path = "/batchJobExecution/{jobExecutionId}", method = RequestMethod.GET)
    public BatchJobExecution getJobExecution(@PathVariable long jobExecutionId) {
        logger.debug("Received request for jobExcutionId: {}", jobExecutionId);
        return dao.findOne(jobExecutionId);
    }
}
