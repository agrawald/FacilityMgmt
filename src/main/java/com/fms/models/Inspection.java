package com.fms.models;

/**
 * Created by e7006722 on 6/03/14.
 */
public class Inspection {
    private int id;
    private String details;
    private int usageId;

    public Inspection() {
    }

    public Inspection(int id) {
        this.id = id;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Inspection that = (Inspection) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public String getDetails() {

        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getUsageId() {
        return usageId;
    }

    public void setUsageId(int usageId) {
        this.usageId = usageId;
    }
}
