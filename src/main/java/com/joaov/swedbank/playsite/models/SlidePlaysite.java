package com.joaov.swedbank.playsite.models;

import java.util.ArrayList;

public class SlidePlaysite extends GeneralPlaysite {
    public SlidePlaysite(Integer id) {
        super.id = id;
        super.capacity = 3;
        super.playing = new ArrayList<>();
        super.queue = new ArrayList<>();
        super.visitors = 0;
        super.type = PlaysiteType.SLIDE;
    }
}
