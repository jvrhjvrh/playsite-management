package com.joaov.swedbank.kid;

import com.joaov.swedbank.kid.dtos.KidForm;
import com.joaov.swedbank.kid.models.KidModel;

import java.util.List;

public interface IKidService {
    KidModel createKid(KidForm form) throws Exception;

    List<KidModel> getAllKids();

    KidModel getOneKid(Integer id);
}
