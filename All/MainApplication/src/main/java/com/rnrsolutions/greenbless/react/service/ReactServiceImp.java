package com.rnrsolutions.greenbless.react.service;


import com.rnrsolutions.greenbless.ai_project.repository.AIRepository;
import com.rnrsolutions.greenbless.doctor.entity.DoctorEntity;
import com.rnrsolutions.greenbless.react.entity.ReactEntity;
import com.rnrsolutions.greenbless.react.repository.ReactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReactServiceImp implements ReactService{

    @Autowired
    private ReactRepo reactRepo;

    @Override
    public String saveReact(int pQuantity, String pItem) throws Exception{

        LocalDateTime currentDateTime = LocalDateTime.now();


        ReactEntity newObjectReactObject = new ReactEntity(pQuantity,pItem,currentDateTime);

        try {
            reactRepo.save(newObjectReactObject);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Successfully Inserted!";
    }

    @Override
    public List<ReactEntity> getAllReactEntities() {
        return reactRepo.findAll();
    }




}
