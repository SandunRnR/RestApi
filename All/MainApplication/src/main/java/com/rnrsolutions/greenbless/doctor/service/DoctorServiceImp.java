package com.rnrsolutions.greenbless.doctor.service;

import com.rnrsolutions.greenbless.device_environment.entity.DeviceEnvironmentEntity1;
import com.rnrsolutions.greenbless.doctor.entity.DoctorEntity;
import com.rnrsolutions.greenbless.doctor.repository.DoctorRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;

@Service
@Transactional
public class DoctorServiceImp implements DoctorService{

    @Autowired
    private DoctorRepo doctorRepo;

    public String saveDoctor(String pName, String pPhoneNumber) throws Exception{

        DoctorEntity newObjectDoctorObject = new DoctorEntity(pName,pPhoneNumber);

        try {
            doctorRepo.save(newObjectDoctorObject);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Successfully Inserted!";
    }

    @Override
    public List<DoctorEntity> getAllDoctorEntities() {
        return doctorRepo.findAll();
    }

    @Override
    public DoctorEntity getDoctorById(int id) {
        return doctorRepo.findById(id).orElse(null);
    }


}
