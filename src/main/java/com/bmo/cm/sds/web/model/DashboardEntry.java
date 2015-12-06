package com.bmo.cm.sds.web.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by matt on 04/12/2015.
 */

@Entity
@Table(name="BATCH_JOB_EXECUTION")
@SecondaryTable(name="BATCH_JOB_INSTANCE",pkJoinColumns = @PrimaryKeyJoinColumn(name="jobInstanceId", referencedColumnName="jobInstanceId"))
public class DashboardEntry implements Serializable {


    private long jobExecutionId;
    @Column(table="BATCH_JOB_INSTANCE")
    private String jobName;
    @Id
    private long jobInstanceId;
    private LocalDateTime createTime;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
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

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
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
