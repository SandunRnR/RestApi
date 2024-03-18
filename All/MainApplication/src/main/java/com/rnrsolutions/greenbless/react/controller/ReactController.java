package com.rnrsolutions.greenbless.react.controller;


import com.rnrsolutions.greenbless.doctor.dto.DoctorDTO;
import com.rnrsolutions.greenbless.doctor.entity.DoctorEntity;
import com.rnrsolutions.greenbless.doctor.service.DoctorService;
import com.rnrsolutions.greenbless.react.dto.ReactDTO;
import com.rnrsolutions.greenbless.react.entity.ReactEntity;
import com.rnrsolutions.greenbless.react.service.ReactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/react")
public class ReactController {
    @Autowired
    private ReactService reactService;

    @PostMapping("/saveDTO")
    public String saveDoctorWithDTO(
            @RequestBody ReactDTO pReactDTO) throws Exception {
        return reactService.saveReact(pReactDTO.getP_id(),pReactDTO.getProduct_version(),pReactDTO.getName(),
                pReactDTO.getCategory(),pReactDTO.getModel(),pReactDTO.getBrand(),pReactDTO.getData_area(),pReactDTO.getProduct_rec_id()
        );
    }


    @GetMapping("/getAll")
    public List<ReactEntity> getAllReactEntities() {
        return reactService.getAllReactEntities();
    }


}
