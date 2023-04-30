package com.joaov.swedbank.kid.models;

import com.joaov.swedbank.kid.dtos.KidForm;

public class KidModel {
    private final Integer id;
    private final String name;
    private final Integer age;
    private final Integer ticketNumber;
    private final Boolean waitsInQueue;
    private Integer currentPlaySite;

    public KidModel(Integer id, KidForm kidForm) {
        this.id = id;
        this.name = kidForm.getName();
        this.age = kidForm.getAge();
        this.ticketNumber = kidForm.getTicketNumber();

        if (kidForm.getWaitsInQueue() == null) {
           this.waitsInQueue = Math.random() > 0.5;
        } else {
            this.waitsInQueue = kidForm.getWaitsInQueue();
        }

        this.currentPlaySite = null;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getTicketNumber() {
        return ticketNumber;
    }

    public Boolean getWaitsInQueue() {
        return waitsInQueue;
    }

    public Integer getCurrentPlaySite() {
        return currentPlaySite;
    }

    public void setCurrentPlaySite(Integer currentPlaySite) {
        this.currentPlaySite = currentPlaySite;
    }
}
