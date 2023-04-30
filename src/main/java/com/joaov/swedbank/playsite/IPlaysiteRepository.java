package com.joaov.swedbank.playsite;

import com.joaov.swedbank.playsite.models.Playsite;

import java.util.List;

public interface IPlaysiteRepository {
    void createPlaysite (Playsite playsite);
    List<Playsite> getAllPlaysites();
    Integer playSiteSize();
    Playsite getPlaysiteById(Integer id);
}
