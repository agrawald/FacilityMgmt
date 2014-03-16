package com.fms.entity;

import com.fms.models.User;

/**
 * Created by e7006722 on 12/03/14.
 */
public class OwnerEntity {
    private int id;
    private String name;
    private int facilityId;

    public OwnerEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(int facilityId) {
        this.facilityId = facilityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OwnerEntity that = (OwnerEntity) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public OwnerEntity(User user) {
        this.id = user.getId();
        this.facilityId = user.getFacilityId();
        this.name = user.getName();
    }

    public User toUser() {
        User user = new User();
        user.setId(this.getId());
        user.setFacilityId(this.getFacilityId());
        user.setName(this.getName());
        return user;
    }
}
