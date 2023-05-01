package com.joaov.swedbank.playsite;

import com.joaov.swedbank.playsite.models.IPlaysite;

import java.util.List;

public interface IPlaysiteRepository {
    void createPlaysite (IPlaysite playsite);
    List<IPlaysite> getAllPlaysites();
    Integer playSiteSize();
    IPlaysite getPlaysiteById(Integer id);
}
