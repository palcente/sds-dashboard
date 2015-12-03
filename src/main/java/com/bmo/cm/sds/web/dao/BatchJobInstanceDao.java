package com.bmo.cm.sds.web.dao;

import com.bmo.cm.sds.web.model.BatchJobInstance;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by matt on 02/12/2015.
 */
@Transactional
public interface BatchJobInstanceDao extends CrudRepository<BatchJobInstance,Long> {
}
