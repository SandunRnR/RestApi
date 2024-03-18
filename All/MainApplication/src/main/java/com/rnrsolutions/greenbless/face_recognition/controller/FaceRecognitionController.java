package com.rnrsolutions.greenbless.face_recognition.controller;

import com.rnrsolutions.greenbless.device_environment.dto.DeviceEnvironmentEntity1DTO;
import com.rnrsolutions.greenbless.face_recognition.dto.FaceRecognitionDTO;
import com.rnrsolutions.greenbless.face_recognition.entity.FaceRecognitionEntity;
import com.rnrsolutions.greenbless.face_recognition.service.FaceRecognitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ai")
public class FaceRecognitionController {

    @Autowired
    private FaceRecognitionService faceRecognitionService;

    @PostMapping("/upload_image")
    public Object uplaod(
            @RequestParam("file") MultipartFile multipartFile) throws Exception {
        return faceRecognitionService.uplaod( multipartFile);
    }



    @PostMapping("/send_details")
    public String saveData(@RequestBody FaceRecognitionDTO pFaceRecognitionDTO) throws Exception{
        return faceRecognitionService.saveData(pFaceRecognitionDTO.getFileName(),pFaceRecognitionDTO.getRecognized_names(),pFaceRecognitionDTO.getNext_action());
    }



    @GetMapping("/get_all_data")
    public List<FaceRecognitionEntity> getAllData() {
        return faceRecognitionService.getAllData();
    }

//    @GetMapping("/get_filtered_data")
//    public List<String> getFilteredData() {
//        return faceRecognitionService.getFilteredData();
//    }

    @Autowired
    public FaceRecognitionController(FaceRecognitionService faceRecognitionService) {
        this.faceRecognitionService = faceRecognitionService;
    }

    @GetMapping("/first-anjali-profile")
    public FaceRecognitionEntity getFirstAnjaliProfile() {
        return faceRecognitionService.getFirstProfileWithAnjaliAndEmptyRecognizedNames();
    }




}
