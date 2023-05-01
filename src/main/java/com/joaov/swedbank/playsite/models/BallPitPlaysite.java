package com.joaov.swedbank.playsite.models;

import java.util.ArrayList;

public class BallPitPlaysite extends GeneralPlaysite {
    public BallPitPlaysite(Integer id) {
        super.id = id;
        super.capacity = 10;
        super.playing = new ArrayList<>();
        super.queue = new ArrayList<>();
        super.visitors = 0;
        super.type = PlaysiteType.BALL_PIT;
    }
}
