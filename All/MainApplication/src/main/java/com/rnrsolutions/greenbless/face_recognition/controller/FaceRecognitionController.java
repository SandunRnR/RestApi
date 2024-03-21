package com.rnrsolutions.greenbless.face_recognition.controller;

import com.rnrsolutions.greenbless.device_environment.controller.DeviceEnvironmentController1;
import com.rnrsolutions.greenbless.device_environment.dto.DeviceEnvironmentEntity1DTO;
import com.rnrsolutions.greenbless.face_recognition.dto.FaceRecognitionDTO;
import com.rnrsolutions.greenbless.face_recognition.entity.FaceRecognitionEntity;
import com.rnrsolutions.greenbless.face_recognition.service.FaceRecognitionService;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ai")
public class FaceRecognitionController {

    private static final Logger logger = LoggerFactory.getLogger(DeviceEnvironmentController1.class);


    @Autowired
    private FaceRecognitionService faceRecognitionService;


    @PostMapping("/upload_image")
    public Object uplaod(
            @RequestParam("file") MultipartFile multipartFile,
            @RequestParam("nextAction") String nextAction) throws Exception {
        return faceRecognitionService.uplaod(multipartFile,nextAction);
    }


    @PostMapping("/send_details")
    public String saveData(@RequestBody FaceRecognitionDTO pFaceRecognitionDTO) throws Exception{
        return faceRecognitionService.saveData(pFaceRecognitionDTO.getFileName(),
               pFaceRecognitionDTO.getRecognized_names(),pFaceRecognitionDTO.getNext_action());
    }


    @GetMapping("/get_all_data")
    public List<FaceRecognitionEntity> getAllData() {
        return faceRecognitionService.getAllData();
    }


    @Autowired
    public FaceRecognitionController(FaceRecognitionService faceRecognitionService) {
        this.faceRecognitionService = faceRecognitionService;
    }


    @GetMapping("/first-anjali-profile")
    public FaceRecognitionEntity getFirstAnjaliProfile() {
        return faceRecognitionService.getFirstProfileWithAnjaliAndEmptyRecognizedNames();
    }


    @PutMapping("/update-face-recognition-table")
    public String updateFaceRecognition(@RequestBody FaceRecognitionDTO pFaceRecognitionDTO) throws Exception{

        logger.info("Id                   :" + pFaceRecognitionDTO.getId());
        logger.info("Recognized Name      :" + pFaceRecognitionDTO.getRecognized_names());
        logger.info("Next Action          :" + pFaceRecognitionDTO.getNext_action());


        return faceRecognitionService.updateFaceRecognition(pFaceRecognitionDTO.getId(),
               pFaceRecognitionDTO.getRecognized_names(),pFaceRecognitionDTO.getNext_action());
    }

    @GetMapping("/recognized-names-for-rukshan")
    public String getRecognizedNamesForRukshan() {
        return faceRecognitionService.getRecognizedNamesForRukshan();
    }


}
