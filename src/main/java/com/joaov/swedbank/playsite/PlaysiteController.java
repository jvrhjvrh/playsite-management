package com.joaov.swedbank.playsite;

import com.joaov.swedbank.api.CommonResponse;
import com.joaov.swedbank.api.ErrorResponse;
import com.joaov.swedbank.api.SuccessResponse;
import com.joaov.swedbank.kid.models.KidModel;
import com.joaov.swedbank.playsite.dtos.PlaysiteDTO;
import com.joaov.swedbank.playsite.dtos.PlaysiteForm;
import com.joaov.swedbank.playsite.dtos.PlaysiteKidForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlaysiteController {
    private final IPlaysiteService service;

    @Autowired
    public PlaysiteController(IPlaysiteService service) {
        this.service = service;
    }

    @PostMapping("/playsite")
    public CommonResponse<PlaysiteDTO> createPlaysite(@RequestBody PlaysiteForm form){
        try{
            PlaysiteDTO playsiteDTO = service.createPlaysite(form);
            return new SuccessResponse<>(playsiteDTO);
        } catch (Exception e) {
            return new ErrorResponse<>(e.getMessage());
        }
    }

    @GetMapping("/playsite")
    public CommonResponse<List<PlaysiteDTO>> getAllPlaysites(){
        try{
            List<PlaysiteDTO> playsiteDTOList = service.getAllPlaysites();
            return new SuccessResponse<>(playsiteDTOList);
        } catch (Exception e) {
            return new ErrorResponse<>(e.getMessage());
        }
    }

    @GetMapping("/playsite/visitors")
    public CommonResponse<Integer> getVisitors(){
        try{
            Integer visitors = service.getVisitors();
            return new SuccessResponse<>(visitors);
        } catch (Exception e) {
            return new ErrorResponse<>(e.getMessage());
        }
    }

    @PostMapping("/playsite/{id}/add-kid")
    public CommonResponse<KidModel> addKid(@PathVariable("id") Integer id, @RequestBody PlaysiteKidForm form) {
        try{
            KidModel kid = service.addKidToPlaysite(id, form);
            return new SuccessResponse<>(kid);
        } catch (Exception e) {
            return new ErrorResponse<>(e.getMessage());
        }
    }

    @GetMapping("/playsite/{id}")
    public CommonResponse<PlaysiteDTO> getAllPlaysites(@PathVariable("id") Integer id){
        try{
            PlaysiteDTO playsiteDTO = service.getPlaysiteById(id);
            return new SuccessResponse<>(playsiteDTO);
        } catch (Exception e) {
            return new ErrorResponse<>(e.getMessage());
        }
    }

    @PutMapping("/playsite/remove-kid/{kidId}")
    public CommonResponse<KidModel> removeKidFromPlaysite(@PathVariable("kidId") Integer kidId) {
        try{
            KidModel kid = service.removeKidFromPlaysite(kidId);
            return new SuccessResponse<>(kid);
        } catch (Exception e) {
            return new ErrorResponse<>(e.getMessage());
        }
    }
}
