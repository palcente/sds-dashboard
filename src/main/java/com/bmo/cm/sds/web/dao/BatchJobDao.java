package com.bmo.cm.sds.web.dao;

import com.bmo.cm.sds.web.model.BatchJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by matt on 29/11/2015.
 */

@Component
public class BatchJobDao {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private DataSource dataSource;

    public BatchJob getBatchJobById(final long id){
        String SQL = "select * from batch_job_execution where job_execution_id = :id ";
        Map<String,Object> params = new HashMap<>();
        params.put("id",id);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(dataSource);
        return template.queryForObject(SQL,params,new BeanPropertyRowMapper<BatchJob>(BatchJob.class));
    }


}
