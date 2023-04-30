package com.joaov.swedbank.playsite.dtos;

import com.joaov.swedbank.playsite.models.PlaysiteType;

public class PlaysiteForm {

    private PlaysiteType type;

    public PlaysiteForm() {

    }
    public PlaysiteForm(PlaysiteType type) {
        this.type = type;
    }

    public PlaysiteType getType() {
        return type;
    }

    public void setType(PlaysiteType type) {
        this.type = type;
    }
}
