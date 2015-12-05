package com.bmo.cm.sds.web.dao;

import com.bmo.cm.sds.web.model.DashboardEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by matt on 04/12/2015.
 */
public interface DashboardDao extends JpaRepository<DashboardEntry,Long> {

    @SuppressWarnings("JpaQlInspection")
    @Query("select u from DashboardEntry u where u.startTime between ?1 and ?2")
    List<DashboardEntry> findByFromDateBetween(Date date1, Date date2);
}

