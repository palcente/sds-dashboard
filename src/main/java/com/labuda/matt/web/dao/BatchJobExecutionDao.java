package com.labuda.matt.web.dao;

import com.labuda.matt.web.model.BatchJobExecution;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by matt on 05/12/2015.
 */
public interface BatchJobExecutionDao extends JpaRepository<BatchJobExecution,Long> {
}
