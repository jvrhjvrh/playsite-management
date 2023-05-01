package com.joaov.swedbank.playsite.models;

import com.joaov.swedbank.kid.models.KidModel;

import java.util.List;
import java.util.Optional;

public interface IPlaysite {
    Integer getId();

    Integer getCapacity();

    Integer getVisitors();

    Integer getUtilization();

    PlaysiteType getType();

    void addKidToPlaysite(KidModel kid) throws Exception;

    Optional<Integer> findKidByIndexInList(Integer kidId, List<Integer> list);

    void removeKidFromPlaysite(Integer kidId) throws Exception;
}
