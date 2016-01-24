package com.labuda.matt.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by matt on 02/12/2015.
 */
public class BatchJobExecutionParams implements Serializable {

    private long jobExecutionId;
    private String typeCd;
    private String keyName;
    private String StringVal;
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private Date dateVal;
    private long longVal;
    private double doubleVal;
    private String identifying;

    public BatchJobExecutionParams() {
    }

    @Override
    public String toString() {
        return "BatchJobExecutionParams{" +
                "jobExecutionId=" + jobExecutionId +
                ", typeCd='" + typeCd + '\'' +
                ", keyName='" + keyName + '\'' +
                ", StringVal='" + StringVal + '\'' +
                ", dateVal=" + dateVal +
                ", longVal=" + longVal +
                ", doubleVal=" + doubleVal +
                ", identifying='" + identifying + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BatchJobExecutionParams that = (BatchJobExecutionParams) o;

        if (jobExecutionId != that.jobExecutionId) return false;
        if (longVal != that.longVal) return false;
        if (Double.compare(that.doubleVal, doubleVal) != 0) return false;
        if (typeCd != null ? !typeCd.equals(that.typeCd) : that.typeCd != null) return false;
        if (keyName != null ? !keyName.equals(that.keyName) : that.keyName != null) return false;
        if (StringVal != null ? !StringVal.equals(that.StringVal) : that.StringVal != null) return false;
        if (dateVal != null ? !dateVal.equals(that.dateVal) : that.dateVal != null) return false;
        return !(identifying != null ? !identifying.equals(that.identifying) : that.identifying != null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (jobExecutionId ^ (jobExecutionId >>> 32));
        result = 31 * result + (typeCd != null ? typeCd.hashCode() : 0);
        result = 31 * result + (keyName != null ? keyName.hashCode() : 0);
        result = 31 * result + (StringVal != null ? StringVal.hashCode() : 0);
        result = 31 * result + (dateVal != null ? dateVal.hashCode() : 0);
        result = 31 * result + (int) (longVal ^ (longVal >>> 32));
        temp = Double.doubleToLongBits(doubleVal);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (identifying != null ? identifying.hashCode() : 0);
        return result;
    }

    public long getJobExecutionId() {
        return jobExecutionId;
    }

    public void setJobExecutionId(long jobExecutionId) {
        this.jobExecutionId = jobExecutionId;
    }

    public String getTypeCd() {
        return typeCd;
    }

    public void setTypeCd(String typeCd) {
        this.typeCd = typeCd;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getStringVal() {
        return StringVal;
    }

    public void setStringVal(String stringVal) {
        StringVal = stringVal;
    }

    public Date getDateVal() {
        return dateVal;
    }

    public void setDateVal(Date dateVal) {
        this.dateVal = dateVal;
    }

    public long getLongVal() {
        return longVal;
    }

    public void setLongVal(long longVal) {
        this.longVal = longVal;
    }

    public double getDoubleVal() {
        return doubleVal;
    }

    public void setDoubleVal(double doubleVal) {
        this.doubleVal = doubleVal;
    }

    public String getIdentifying() {
        return identifying;
    }

    public void setIdentifying(String identifying) {
        this.identifying = identifying;
    }
}
