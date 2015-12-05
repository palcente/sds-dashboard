package com.bmo.cm.sds.web.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by matt on 04/12/2015.
 */

@Entity
@Table(name="BATCH_JOB_EXECUTION")
@SecondaryTable(name="BATCH_JOB_INSTANCE",pkJoinColumns = @PrimaryKeyJoinColumn(name="jobInstanceId", referencedColumnName="jobExecutionId"))
public class DashboardEntry implements Serializable {

    @Id
    private long jobExecutionId;
    @Column(table="BATCH_JOB_INSTANCE")
    private String jobName;
    private long jobInstanceId;
    private Date createTime;
    private Date startTime;
    private Date endTime;
    private String status;
    private String exitCode;


    public DashboardEntry() {
    }


    public long getJobInstanceId() {
        return jobInstanceId;
    }

    public void setJobInstanceId(long jobInstanceId) {
        this.jobInstanceId = jobInstanceId;
    }

    public long getJobExecutionId() {
        return jobExecutionId;
    }

    public void setJobExecutionId(long jobExecutionId) {
        this.jobExecutionId = jobExecutionId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getExitCode() {
        return exitCode;
    }

    public void setExitCode(String exitCode) {
        this.exitCode = exitCode;
    }
}
