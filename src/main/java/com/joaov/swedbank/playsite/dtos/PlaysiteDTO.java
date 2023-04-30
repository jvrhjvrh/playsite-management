package com.joaov.swedbank.playsite.dtos;

import com.joaov.swedbank.playsite.models.Playsite;
import com.joaov.swedbank.playsite.models.PlaysiteType;

public class PlaysiteDTO {
    Integer id;
    Integer capacity;
    Integer visitors;
    PlaysiteType type;
    Integer utilization;

    public PlaysiteDTO() {
    }

    public PlaysiteDTO(Playsite playsite) {
        id = playsite.getId();
        capacity = playsite.getCapacity();
        visitors = playsite.getVisitors();
        type = playsite.getType();
        utilization = playsite.getUtilization();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getVisitors() {
        return visitors;
    }

    public void setVisitors(Integer visitors) {
        this.visitors = visitors;
    }

    public PlaysiteType getType() {
        return type;
    }

    public void setType(PlaysiteType type) {
        this.type = type;
    }

    public Integer getUtilization() {
        return utilization;
    }

    public void setUtilization(Integer utilization) {
        this.utilization = utilization;
    }
}
