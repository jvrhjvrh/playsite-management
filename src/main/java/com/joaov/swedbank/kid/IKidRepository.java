package com.joaov.swedbank.kid;

import com.joaov.swedbank.kid.models.KidModel;

import java.util.List;

public interface IKidRepository {
    void addKid(KidModel kid);
    KidModel getKidById(Integer id);
    List<KidModel> getAllKids();
    Integer kidAmount();
}
