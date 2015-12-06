package com.labuda.matt.web.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by matt on 02/12/2015.
 */
@Entity
@Table(name="BATCH_JOB_INSTANCE")
public class BatchJobInstance implements Serializable {

    @Id
    private long jobInstanceId;
    @NotNull
    private long version;
    @NotNull
    private String jobName;
    @NotNull
    private String jobKey;

    public BatchJobInstance() {
    }

    @Override
    public String toString() {
        return "BatchJobInstance{" +
                "jobInstanceId=" + jobInstanceId +
                ", version=" + version +
                ", jobName='" + jobName + '\'' +
                ", jobKey='" + jobKey + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BatchJobInstance that = (BatchJobInstance) o;

        if (jobInstanceId != that.jobInstanceId) return false;
        if (version != that.version) return false;
        if (jobName != null ? !jobName.equals(that.jobName) : that.jobName != null) return false;
        return !(jobKey != null ? !jobKey.equals(that.jobKey) : that.jobKey != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (jobInstanceId ^ (jobInstanceId >>> 32));
        result = 31 * result + (int) (version ^ (version >>> 32));
        result = 31 * result + (jobName != null ? jobName.hashCode() : 0);
        result = 31 * result + (jobKey != null ? jobKey.hashCode() : 0);
        return result;
    }

    public long getJobInstanceId() {
        return jobInstanceId;
    }

    public void setJobInstanceId(long jobInstanceId) {
        this.jobInstanceId = jobInstanceId;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobKey() {
        return jobKey;
    }

    public void setJobKey(String jobKey) {
        this.jobKey = jobKey;
    }
}
