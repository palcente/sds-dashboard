package com.labuda.matt.web.controller.rest;

import com.labuda.matt.web.dao.BatchStepExecutionDao;
import com.labuda.matt.web.model.BatchStepExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by matt on 06/12/2015.
 * TODO: Caching logic works but it's nasty... Could use some refactoring. It can fail in some extreme cases and not display all steps properly.
 */

@RestController
public class BatchStepExecutionController {

    private static Logger logger = LoggerFactory.getLogger(BatchStepExecutionController.class);

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private BatchStepExecutionDao dao;

    @Cacheable(cacheNames = "batchStepExecutionPerJobExecutionId",
            unless= "#result.size()>0 " +
                    "&&  (#result.get(#result.size()-1).status=='STARTED'  || " +
                        "#result.get(#result.size()-1).status=='STARTING' || " +
                        "#result.get(#result.size()-1).status=='STOPPING' || " +
                        "#result.get(#result.size()-1).status=='UNKNOWN')")
    @RequestMapping(path ="/batchStepExecutionPerJobExecutionId/{jobExecutionId}", method = RequestMethod.GET)
    public List<BatchStepExecution> getStepsPerJobExecutionId(@PathVariable long jobExecutionId) {
        logger.debug("Received request for steps of jobExecution : {}", jobExecutionId);
        return dao.findStepsByjobExecutionId(jobExecutionId);
    }

}
