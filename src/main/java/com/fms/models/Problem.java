package com.fms.models;

/**
 * Created by e7006722 on 6/03/14.
 */
public class Problem {
    public String getResolvedOn() {
        return resolvedOn;
    }

    public void setResolvedOn(String resolvedOn) {
        this.resolvedOn = resolvedOn;
    }

    public Integer getMaintenanceId() {
        return maintenanceId;
    }

    public void setMaintenanceId(Integer maintenanceId) {
        this.maintenanceId = maintenanceId;
    }

    public Problem() {
    }

    private int id;
    private String details;
    private String foundOn;
    private String isResolved;

    public Problem(int id) {
        this.id = id;
    }

    private String resolvedOn;
    private int maintenanceId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Problem)) return false;

        Problem problem = (Problem) o;

        return id == problem.id;

    }

    @Override
    public int hashCode() {
        return id;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getFoundOn() {
        return foundOn;
    }

    public void setFoundOn(String foundOn) {
        this.foundOn = foundOn;
    }

    public String getIsResolved() {
        return isResolved;
    }

    public void setIsResolved(String isResolved) {
        this.isResolved = isResolved;
    }
}
