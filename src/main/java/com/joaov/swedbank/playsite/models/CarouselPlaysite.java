package com.joaov.swedbank.playsite.models;

import java.util.ArrayList;

public class CarouselPlaysite extends GeneralPlaysite {
    public CarouselPlaysite(Integer id) {
        super.id = id;
        super.capacity = 8;
        super.playing = new ArrayList<>();
        super.queue = new ArrayList<>();
        super.visitors = 0;
        super.type = PlaysiteType.CAROUSEL;
    }
}
