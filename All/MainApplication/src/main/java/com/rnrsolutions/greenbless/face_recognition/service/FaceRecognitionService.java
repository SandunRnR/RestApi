package com.rnrsolutions.greenbless.face_recognition.service;

import com.rnrsolutions.greenbless.face_recognition.dto.FaceRecognitionDTO;
import com.rnrsolutions.greenbless.face_recognition.entity.FaceRecognitionEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface FaceRecognitionService {
    String uplaod(MultipartFile multipartFile, String nextAction) throws Exception;

    String uploadImage(File file, String fileName) throws IOException;

    String saveData(String fileName, String recognizedNames, String nextAction) throws Exception;

    List<FaceRecognitionEntity> getAllData();


//    List<String> getFilteredData();

    FaceRecognitionEntity getFirstProfileWithAnjaliAndEmptyRecognizedNames();

    String updateFaceRecognition(int id, String recognizedNames, String nextAction) throws Exception;

//    void updateRecognizedNamesByFileName(String file_name, String recognizedNames);

}
