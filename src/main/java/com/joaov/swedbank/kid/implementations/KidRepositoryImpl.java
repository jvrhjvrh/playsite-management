package com.joaov.swedbank.kid.implementations;

import com.joaov.swedbank.kid.IKidRepository;
import com.joaov.swedbank.kid.models.KidModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class KidRepositoryImpl implements IKidRepository {
    List<KidModel> kidList = new ArrayList<>();

    @Override
    public void addKid(KidModel kid) {
        kidList.add(kid);
    }

    @Override
    public KidModel getKidById(Integer id) {
        return kidList.get(id);
    }

    @Override
    public List<KidModel> getAllKids() {
        return kidList;
    }

    @Override
    public Integer kidAmount() {
        return kidList.size();
    }
}
