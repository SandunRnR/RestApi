package com.rnrsolutions.greenbless.doctor.service;

import com.rnrsolutions.greenbless.device_environment.entity.DeviceEnvironmentEntity1;
import com.rnrsolutions.greenbless.doctor.entity.DoctorEntity;

import java.util.List;

public interface DoctorService {
    public String saveDoctor(String pName, String pPhoneNumber) throws Exception;
    public List<DoctorEntity> getAllDoctorEntities();

    public DoctorEntity getDoctorById(int id);




}
