package com.rnrsolutions.greenbless.react.service;

import com.rnrsolutions.greenbless.doctor.entity.DoctorEntity;
import com.rnrsolutions.greenbless.react.entity.ReactEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface ReactService {
//    public String saveReact(int pQuantity, String pItem) throws Exception;

    public List<ReactEntity> getAllReactEntities();

    String saveReact(String pId, double productVersion, String name, String category, String model, String brand, String dataArea, String productRecId) throws Exception;
}
