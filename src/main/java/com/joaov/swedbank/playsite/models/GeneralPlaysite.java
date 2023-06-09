package com.joaov.swedbank.playsite.models;

import com.joaov.swedbank.kid.models.KidModel;

import java.util.List;
import java.util.Optional;

public abstract class GeneralPlaysite implements IPlaysite {
    Integer id;
    Integer capacity;
    List<Integer> playing;
    List<Integer> queue;
    Integer visitors;
    PlaysiteType type;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public Integer getCapacity() {
        return capacity;
    }

    @Override
    public Integer getVisitors() {
        return visitors;
    }

    @Override
    public Integer getUtilization() {
        return (int) ((playing.size() *100.0f) / capacity);
    }

    @Override
    public PlaysiteType getType() {
        return type;
    }

    private Boolean isKidInPlaysite(Integer kidId) {
        Optional<Integer> kidInPlaying = findKidByIndexInList(kidId, playing);
        if(kidInPlaying.isPresent()) return true;

        Optional<Integer> kidInQueue = findKidByIndexInList(kidId, queue);
        return kidInQueue.isPresent();
    }

    @Override
    public void addKidToPlaysite(KidModel kid) throws Exception {
        if (isKidInPlaysite(kid.getId())) {
            throw new Exception("Kid already in site");
        }

        if (playing.size() >= capacity) {
            if(!kid.getWaitsInQueue()) {
                throw new Exception("Play site is full and kid does not accept to wait in queue");
            }
            queue.add(kid.getId());
        } else {
            playing.add(kid.getId());
        }

        visitors++;
    }
    @Override
    public Optional<Integer> findKidByIndexInList(Integer kidId, List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).equals(kidId)) {
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }
    @Override
    public void removeKidFromPlaysite(Integer kidId) throws Exception {
        Optional<Integer> kidInPlaying = findKidByIndexInList(kidId, playing);
        if(kidInPlaying.isPresent()) {
            playing.remove(kidInPlaying.get());
            if(queue.size() > 0) {
                playing.add(queue.remove(0));
            }
            return;
        }
        Optional<Integer> kidInQueue = findKidByIndexInList(kidId, queue);
        if(kidInQueue.isPresent()) {
            queue.remove(kidInQueue.get());
            return;
        }
        throw new Exception("Kid not found");
    }
}
