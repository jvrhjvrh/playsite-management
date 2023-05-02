package com.joaov.swedbank.kid.implementations;

import com.joaov.swedbank.kid.IKidRepository;
import com.joaov.swedbank.kid.IKidService;
import com.joaov.swedbank.kid.dtos.KidForm;
import com.joaov.swedbank.kid.models.KidModel;
import com.joaov.swedbank.playsite.dtos.PlaysiteKidForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KidServiceImpl implements IKidService {
    private final IKidRepository database;

    @Autowired
    public KidServiceImpl(IKidRepository database) {
        this.database = database;
    }

    @Override
    public KidModel createKid(KidForm form) throws Exception {
        if(form.getAge() == null || form.getName() == null || form.getTicketNumber() == null) {
            throw new Exception("Kid's age, name and ticket number can't be null");
        }
        KidModel kid = new KidModel(database.kidAmount(), form);
        database.addKid(kid);
        return kid;
    }
    @Override
    public KidModel createKid(PlaysiteKidForm form) throws Exception {
        if(form.getAge() == null || form.getName() == null || form.getTicketNumber() == null) {
            throw new Exception("Kid's age, name and ticket number can't be null");
        }

        KidForm kidForm = new KidForm();
        kidForm.setAge(form.getAge());
        kidForm.setName(form.getName());
        kidForm.setTicketNumber(form.getTicketNumber());
        kidForm.setWaitsInQueue(form.getWaitsInQueue());

        return createKid(kidForm);
    }

    @Override
    public List<KidModel> getAllKids() {
        return database.getAllKids();
    }

    @Override
    public KidModel getOneKid(Integer id) {
        return database.getKidById(id);
    }
}
