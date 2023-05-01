package com.joaov.swedbank.playsite.implementations;

import com.joaov.swedbank.kid.IKidService;
import com.joaov.swedbank.kid.dtos.KidForm;
import com.joaov.swedbank.kid.models.KidModel;
import com.joaov.swedbank.playsite.IPlaysiteRepository;
import com.joaov.swedbank.playsite.IPlaysiteService;
import com.joaov.swedbank.playsite.dtos.PlaysiteDTO;
import com.joaov.swedbank.playsite.dtos.PlaysiteForm;
import com.joaov.swedbank.playsite.dtos.PlaysiteKidForm;
import com.joaov.swedbank.playsite.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaysiteServiceImpl implements IPlaysiteService {
    private final IPlaysiteRepository database;
    private final IKidService kidService;

    @Autowired
    public PlaysiteServiceImpl(IPlaysiteRepository database, IKidService kidService) {
        this.database = database;
        this.kidService = kidService;
    }

    @Override
    public PlaysiteDTO createPlaysite(PlaysiteForm form) {
        IPlaysite playsite = switch (form.getType()) {
            case SLIDE -> new SlidePlaysite(database.playSiteSize());
            case CAROUSEL -> new CarouselPlaysite(database.playSiteSize());
            case BALL_PIT -> new BallPitPlaysite(database.playSiteSize());
            case DOUBLE_SWING -> new DoubleSwingPlaysite(database.playSiteSize());
        };
        database.createPlaysite(playsite);
        return new PlaysiteDTO(playsite);
    }

    @Override
    public List<PlaysiteDTO> getAllPlaysites() {
        List<IPlaysite> playsites = database.getAllPlaysites();
        return playsites.stream().map(PlaysiteDTO::new).toList();
    }

    @Override
    public PlaysiteDTO getPlaysiteById(Integer id) {
        return new PlaysiteDTO(database.getPlaysiteById(id));
    }

    @Override
    public Integer getVisitors() {
        return database
                .getAllPlaysites()
                .stream()
                .reduce(0, (acc, playsite) -> acc + playsite.getVisitors(), Integer::sum);
    }

    @Override
    public KidModel addKidToPlaysite(Integer playsiteId, PlaysiteKidForm playsiteKidForm) throws Exception {
        KidModel kid;
        if(playsiteKidForm.getId() != null) {
            kid = kidService.getOneKid(playsiteKidForm.getId());
        } else {
            KidForm kidForm = new KidForm();
            kidForm.setAge(playsiteKidForm.getAge());
            kidForm.setName(playsiteKidForm.getName());
            kidForm.setTicketNumber(playsiteKidForm.getTicketNumber());
            kidForm.setWaitsInQueue(playsiteKidForm.getWaitsInQueue());
            kid = kidService.createKid(kidForm);
        }
        IPlaysite playsite = database.getPlaysiteById(playsiteId);

        playsite.addKidToPlaysite(kid);

        if (kid.getCurrentPlaySite() != null) {
            removeKidFromPlaysite(kid.getId());
        }

        kid.setCurrentPlaySite(playsiteId);
        return kid;
    }

    @Override
    public KidModel removeKidFromPlaysite(Integer kidId) throws Exception {
        KidModel kid = kidService.getOneKid(kidId);
        IPlaysite playsite = database.getPlaysiteById(kid.getCurrentPlaySite());
        playsite.removeKidFromPlaysite(kid.getId());
        kid.setCurrentPlaySite(null);
        return kid;
    }
}
