package com.liziczh.ims.domain;

import java.util.Objects;

public class Record {
    private String date;
    private int proId;
    private String proName;
    private int count;
    private String register;
    private String recordType;

    public Record() {
    }

    public Record(String date, int proId, String proName, int count, String register, String recordType) {
        this.date = date;
        this.proId = proId;
        this.proName = proName;
        this.count = count;
        this.register = register;
        this.recordType = recordType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return proId == record.proId &&
                count == record.count &&
                Objects.equals(date, record.date) &&
                Objects.equals(proName, record.proName) &&
                Objects.equals(register, record.register) &&
                Objects.equals(recordType, record.recordType);
    }

    @Override
    public int hashCode() {

        return Objects.hash(date, proId, proName, count, register, recordType);
    }

    @Override
    public String toString() {
        return "Record{" +
                "date='" + date + '\'' +
                ", proId=" + proId +
                ", proName='" + proName + '\'' +
                ", count=" + count +
                ", register='" + register + '\'' +
                ", recordType='" + recordType + '\'' +
                '}';
    }
}
