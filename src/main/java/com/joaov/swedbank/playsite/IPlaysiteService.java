package com.joaov.swedbank.playsite;

import com.joaov.swedbank.kid.models.KidModel;
import com.joaov.swedbank.playsite.dtos.PlaysiteDTO;
import com.joaov.swedbank.playsite.dtos.PlaysiteForm;
import com.joaov.swedbank.playsite.dtos.PlaysiteKidForm;

import java.util.List;

public interface IPlaysiteService {
    PlaysiteDTO createPlaysite(PlaysiteForm form);

    List<PlaysiteDTO> getAllPlaysites();

    PlaysiteDTO getPlaysiteById(Integer id);

    Integer getVisitors();


    KidModel addKidToPlaysite(Integer playsiteId, PlaysiteKidForm kidForm) throws Exception;

    KidModel removeKidFromPlaysite(Integer kidId) throws Exception;
}
