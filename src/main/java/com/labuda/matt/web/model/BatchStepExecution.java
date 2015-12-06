package com.labuda.matt.web.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by matt on 02/12/2015.
 */
@Entity
@Table(name = "BATCH_STEP_EXECUTION")
public class BatchStepExecution implements Serializable {

    @Id
    private long stepExecutionId;
    private String version;
    private String stepName;
    private long jobExecutionId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status;
    private long commitCount;
    private long readCount;
    private long filterCount;
    private long writeCount;
    private long readSkipCount;
    private long writeSkipCount;
    private long processSkipCount;
    private long rollbackCount;
    private String exitCode;
    private String exitMessage;
    private LocalDateTime lastUpdated;

    public BatchStepExecution() {
    }

    @Override
    public String toString() {
        return "BatchStepExecution{" +
                "stepExecutionId=" + stepExecutionId +
                ", version='" + version + '\'' +
                ", stepName='" + stepName + '\'' +
                ", jobExecutionId=" + jobExecutionId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", status='" + status + '\'' +
                ", commitCount=" + commitCount +
                ", readCount=" + readCount +
                ", filterCount=" + filterCount +
                ", writeCount=" + writeCount +
                ", readSkipCount=" + readSkipCount +
                ", writeSkipCount=" + writeSkipCount +
                ", processSkipCount=" + processSkipCount +
                ", rollbackCount=" + rollbackCount +
                ", exitCode='" + exitCode + '\'' +
                ", exitMessage='" + exitMessage + '\'' +
                ", lastUpdated=" + lastUpdated +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BatchStepExecution that = (BatchStepExecution) o;

        if (stepExecutionId != that.stepExecutionId) return false;
        if (jobExecutionId != that.jobExecutionId) return false;
        if (commitCount != that.commitCount) return false;
        if (readCount != that.readCount) return false;
        if (filterCount != that.filterCount) return false;
        if (writeCount != that.writeCount) return false;
        if (readSkipCount != that.readSkipCount) return false;
        if (writeSkipCount != that.writeSkipCount) return false;
        if (processSkipCount != that.processSkipCount) return false;
        if (rollbackCount != that.rollbackCount) return false;
        if (version != null ? !version.equals(that.version) : that.version != null) return false;
        if (stepName != null ? !stepName.equals(that.stepName) : that.stepName != null) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (exitCode != null ? !exitCode.equals(that.exitCode) : that.exitCode != null) return false;
        if (exitMessage != null ? !exitMessage.equals(that.exitMessage) : that.exitMessage != null) return false;
        return !(lastUpdated != null ? !lastUpdated.equals(that.lastUpdated) : that.lastUpdated != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (stepExecutionId ^ (stepExecutionId >>> 32));
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (stepName != null ? stepName.hashCode() : 0);
        result = 31 * result + (int) (jobExecutionId ^ (jobExecutionId >>> 32));
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (int) (commitCount ^ (commitCount >>> 32));
        result = 31 * result + (int) (readCount ^ (readCount >>> 32));
        result = 31 * result + (int) (filterCount ^ (filterCount >>> 32));
        result = 31 * result + (int) (writeCount ^ (writeCount >>> 32));
        result = 31 * result + (int) (readSkipCount ^ (readSkipCount >>> 32));
        result = 31 * result + (int) (writeSkipCount ^ (writeSkipCount >>> 32));
        result = 31 * result + (int) (processSkipCount ^ (processSkipCount >>> 32));
        result = 31 * result + (int) (rollbackCount ^ (rollbackCount >>> 32));
        result = 31 * result + (exitCode != null ? exitCode.hashCode() : 0);
        result = 31 * result + (exitMessage != null ? exitMessage.hashCode() : 0);
        result = 31 * result + (lastUpdated != null ? lastUpdated.hashCode() : 0);
        return result;
    }

    public long getStepExecutionId() {
        return stepExecutionId;
    }

    public void setStepExecutionId(long stepExecutionId) {
        this.stepExecutionId = stepExecutionId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getStepName() {
        return stepName;
    }

    public void setStepName(String stepName) {
        this.stepName = stepName;
    }

    public long getJobExecutionId() {
        return jobExecutionId;
    }

    public void setJobExecutionId(long jobExecutionId) {
        this.jobExecutionId = jobExecutionId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getCommitCount() {
        return commitCount;
    }

    public void setCommitCount(long commitCount) {
        this.commitCount = commitCount;
    }

    public long getReadCount() {
        return readCount;
    }

    public void setReadCount(long readCount) {
        this.readCount = readCount;
    }

    public long getFilterCount() {
        return filterCount;
    }

    public void setFilterCount(long filterCount) {
        this.filterCount = filterCount;
    }

    public long getWriteCount() {
        return writeCount;
    }

    public void setWriteCount(long writeCount) {
        this.writeCount = writeCount;
    }

    public long getReadSkipCount() {
        return readSkipCount;
    }

    public void setReadSkipCount(long readSkipCount) {
        this.readSkipCount = readSkipCount;
    }

    public long getWriteSkipCount() {
        return writeSkipCount;
    }

    public void setWriteSkipCount(long writeSkipCount) {
        this.writeSkipCount = writeSkipCount;
    }

    public long getProcessSkipCount() {
        return processSkipCount;
    }

    public void setProcessSkipCount(long processSkipCount) {
        this.processSkipCount = processSkipCount;
    }

    public long getRollbackCount() {
        return rollbackCount;
    }

    public void setRollbackCount(long rollbackCount) {
        this.rollbackCount = rollbackCount;
    }

    public String getExitCode() {
        return exitCode;
    }

    public void setExitCode(String exitCode) {
        this.exitCode = exitCode;
    }

    public String getExitMessage() {
        return exitMessage;
    }

    public void setExitMessage(String exitMessage) {
        this.exitMessage = exitMessage;
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

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
