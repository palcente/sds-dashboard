package com.bmo.cm.sds.web.dao;

import com.bmo.cm.sds.web.model.BatchJobInstance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.transaction.Transactional;
import java.sql.Date;

/**
 * Created by matt on 02/12/2015.
 */
public interface BatchJobInstanceDao extends CrudRepository<BatchJobInstance,Long> {
}
