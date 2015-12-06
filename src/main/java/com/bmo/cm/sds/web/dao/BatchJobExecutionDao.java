package com.bmo.cm.sds.web.dao;

import com.bmo.cm.sds.web.model.BatchJobExecution;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by matt on 05/12/2015.
 */
public interface BatchJobExecutionDao extends JpaRepository<BatchJobExecution,Long> {
}
