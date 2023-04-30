package com.joaov.swedbank.playsite.implementations;

import com.joaov.swedbank.playsite.IPlaysiteRepository;
import com.joaov.swedbank.playsite.models.Playsite;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PlaysiteRepositoryImpl implements IPlaysiteRepository {
    List<Playsite> playsites = new ArrayList<>();

    @Override
    public void createPlaysite(Playsite playsite) {
        playsites.add(playsite);
    }

    @Override
    public List<Playsite> getAllPlaysites() {
        return playsites;
    }

    @Override
    public Integer playSiteSize() {
        return playsites.size();
    }

    @Override
    public Playsite getPlaysiteById(Integer id) {
        return playsites.get(id);
    }
}
