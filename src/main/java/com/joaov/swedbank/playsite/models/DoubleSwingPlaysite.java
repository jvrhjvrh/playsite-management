package com.joaov.swedbank.playsite.models;

import java.util.ArrayList;

public class DoubleSwingPlaysite extends GeneralPlaysite {
    public DoubleSwingPlaysite(Integer id) {
        super.id = id;
        super.capacity = 2;
        super.playing = new ArrayList<>();
        super.queue = new ArrayList<>();
        super.visitors = 0;
        super.type = PlaysiteType.DOUBLE_SWING;
    }

    @Override
    public Integer getUtilization() {
        if(playing.size() == 2) {
            return 100;
        }
        return 0;
    }
}
