package com.liziczh.ims.domain;

import java.util.Objects;

public class ProductDir {
    private int dirId;
    private String dirName;

    public ProductDir(){

    }

    public ProductDir(int dirId, String dirName) {
        this.dirId = dirId;
        this.dirName = dirName;
    }

    public int getDirId() {
        return dirId;
    }

    public void setDirId(int dirId) {
        this.dirId = dirId;
    }

    public String getDirName() {
        return dirName;
    }

    public void setDirName(String dirName) {
        this.dirName = dirName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDir that = (ProductDir) o;
        return dirId == that.dirId &&
                Objects.equals(dirName, that.dirName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(dirId, dirName);
    }

    @Override
    public String toString() {
        return "ProductDir{" +
                "dirId=" + dirId +
                ", dirName='" + dirName + '\'' +
                '}';
    }
}
