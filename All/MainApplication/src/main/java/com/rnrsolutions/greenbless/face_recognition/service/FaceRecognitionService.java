package com.rnrsolutions.greenbless.face_recognition.service;

import com.rnrsolutions.greenbless.face_recognition.dto.FaceRecognitionDTO;
import com.rnrsolutions.greenbless.face_recognition.entity.FaceRecognitionEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface FaceRecognitionService {
    String uplaod(MultipartFile multipartFile) throws Exception;

    String uploadImage(File file, String fileName) throws IOException;

    String saveData(String fileName, String recognizedNames, String nextAction) throws Exception;

    List<FaceRecognitionEntity> getAllData();

//    List<String> getFilteredData();



}
