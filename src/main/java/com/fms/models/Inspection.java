package com.fms.models;

/**
 * Created by e7006722 on 6/03/14.
 */
public class Inspection {
    private Integer id;
    private String details;
    private Integer usageId;

    public Inspection() {
    }

    public Inspection(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Inspection)) return false;

        Inspection that = (Inspection) o;

        return id == that.id;

    }

    @Override
    public int hashCode() {
        return id;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Integer getUsageId() {
        return usageId;
    }

    public void setUsageId(Integer usageId) {
        this.usageId = usageId;
    }
}
