package com.joaov.swedbank.kid;

import com.joaov.swedbank.api.CommonResponse;
import com.joaov.swedbank.api.ErrorResponse;
import com.joaov.swedbank.api.SuccessResponse;
import com.joaov.swedbank.kid.dtos.KidForm;
import com.joaov.swedbank.kid.models.KidModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KidController {
    private final IKidService service;

    @Autowired
    public KidController(IKidService service) {
        this.service = service;
    }

    @PostMapping("/kid")
    public CommonResponse<KidModel> createKid(@RequestBody KidForm form){
        try{
            KidModel kid = service.createKid(form);
            return new SuccessResponse<>(kid);
        } catch (Exception e) {
            return new ErrorResponse<>(e.getMessage());
        }
    }

    @GetMapping("/kid")
    public CommonResponse<List<KidModel>> getAllKids(){
        try{
            List<KidModel> kids = service.getAllKids();
            return new SuccessResponse<>(kids);
        } catch (Exception e) {
            return new ErrorResponse<>(e.getMessage());
        }
    }

    @GetMapping("/kid/{id}")
    public CommonResponse<KidModel> getOneKid(@PathVariable("id") Integer id){
        try{
            KidModel kid = service.getOneKid(id);
            return new SuccessResponse<>(kid);
        } catch (Exception e) {
            return new ErrorResponse<>(e.getMessage());
        }
    }
}
