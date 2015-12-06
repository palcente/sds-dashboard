package com.bmo.cm.sds.web.dao;

import com.bmo.cm.sds.web.model.BatchJobExecution;
import com.bmo.cm.sds.web.model.BatchStepExecution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by matt on 05/12/2015.
 */
public interface BatchStepExecutionDao extends JpaRepository<BatchJobExecution,Long> {

    @SuppressWarnings("JpaQlInspection")
    @Query("select u from BatchStepExecution u where u.jobExecutionId = ?1")
    List<BatchStepExecution> findStepsByjobExecutionId(long jobExecutionId);
}
