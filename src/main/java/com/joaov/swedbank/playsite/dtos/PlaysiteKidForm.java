package com.joaov.swedbank.playsite.dtos;

public class PlaysiteKidForm {
    private Integer id;
    private Integer age;
    private String name;
    private Integer ticketNumber;
    private Boolean waitsInQueue;

    public PlaysiteKidForm() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(Integer ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public Boolean getWaitsInQueue() {
        return waitsInQueue;
    }

    public void setWaitsInQueue(Boolean waitsInQueue) {
        this.waitsInQueue = waitsInQueue;
    }
}
