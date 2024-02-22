package com.rnrsolutions.greenbless.doctor.controller;


import com.rnrsolutions.greenbless.device_environment.dto.DeviceEnvironmentEntity1DTO;
import com.rnrsolutions.greenbless.device_environment.entity.DeviceEnvironmentEntity1;
import com.rnrsolutions.greenbless.device_environment.service.DeviceEnvironmentService1;
import com.rnrsolutions.greenbless.doctor.dto.DoctorDTO;
import com.rnrsolutions.greenbless.doctor.entity.DoctorEntity;
import com.rnrsolutions.greenbless.doctor.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/saveDTO")
    public String saveDoctorWithDTO(
            @RequestBody DoctorDTO pDoctorDTO) throws Exception {
        return doctorService.saveDoctor(pDoctorDTO.getName(),
                pDoctorDTO.getPhoneNumber(), pDoctorDTO.getToken(),pDoctorDTO.getChatText()
        );
    }

    @GetMapping("/getAll")
    public List<DoctorEntity> getAllDoctorEntities() {
        return doctorService.getAllDoctorEntities();
    }

    @GetMapping("/getName/{id}")
    public String getDoctorNameById(@PathVariable int id) {
        DoctorEntity doctorEntity = doctorService.getDoctorById(id);
        return doctorEntity != null ? doctorEntity.getName() : "Doctor not found";
    }

    @GetMapping("/getPhoneNumber/{id}")
    public String getDoctorPhoneNumberById(@PathVariable int id) {
        DoctorEntity doctorEntity = doctorService.getDoctorById(id);
        return doctorEntity != null ? doctorEntity.getPhoneNumber() : "Doctor not found";
    }


    @GetMapping("/getToken/{id}")
    public String getTokenBy(@PathVariable int id){
        DoctorEntity doctorEntity = doctorService.getDoctorById(id);
        return doctorEntity != null ? doctorEntity.getToken():"Token not Found";
    }

    @GetMapping("/getIpAddress/{id}")
    public String getIPAddressById(@PathVariable int id){
        DoctorEntity doctorEntity = doctorService.getDoctorById(id);
        return doctorEntity != null ? doctorEntity.getToken() : "Ip not valid for Ip Address";
    }
}
