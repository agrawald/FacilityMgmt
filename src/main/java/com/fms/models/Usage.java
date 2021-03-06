package com.fms.models;

/**
 * Created by e7006722 on 6/03/14.
 */
public class Usage {
    private int id;
    private int facilityId;
    private String startDate;
    private String endDate;

    public Usage(int id) {
        this.id = id;
    }

    public Usage() {
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(int facilityId) {
        this.facilityId = facilityId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usage usage = (Usage) o;

        if (id != usage.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
