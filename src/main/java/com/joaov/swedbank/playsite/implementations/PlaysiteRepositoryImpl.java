package com.joaov.swedbank.playsite.implementations;

import com.joaov.swedbank.playsite.IPlaysiteRepository;
import com.joaov.swedbank.playsite.models.IPlaysite;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PlaysiteRepositoryImpl implements IPlaysiteRepository {
    List<IPlaysite> playsites = new ArrayList<>();

    @Override
    public void createPlaysite(IPlaysite playsite) {
        playsites.add(playsite);
    }

    @Override
    public List<IPlaysite> getAllPlaysites() {
        return playsites;
    }

    @Override
    public Integer playSiteSize() {
        return playsites.size();
    }

    @Override
    public IPlaysite getPlaysiteById(Integer id) {
        return playsites.get(id);
    }
}
