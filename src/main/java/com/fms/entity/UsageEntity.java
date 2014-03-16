package com.fms.entity;

import com.fms.models.Usage;

/**
 * Created by e7006722 on 6/03/14.
 */
public class UsageEntity {
    private Integer id;
    private Integer facilityId;
    private String startDate;
    private String endDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Integer facilityId) {
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

    public UsageEntity() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsageEntity)) return false;

        UsageEntity that = (UsageEntity) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public UsageEntity(Usage usage) {
        this.id = usage.getId();
        this.facilityId = usage.getFacilityId();
        this.startDate = usage.getStartDate();
        this.endDate = usage.getEndDate();
    }

    public Usage toUsage() {
        Usage usage = new Usage();
        usage.setId(this.getId());
        usage.setEndDate(this.getEndDate());
        usage.setFacilityId(this.getFacilityId());
        usage.setStartDate(this.getStartDate());
        return usage;
    }
}
