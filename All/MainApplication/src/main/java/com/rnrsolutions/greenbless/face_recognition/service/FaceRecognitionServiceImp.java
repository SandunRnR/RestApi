package com.rnrsolutions.greenbless.face_recognition.service;

import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.rnrsolutions.greenbless.face_recognition.dto.FaceRecognitionDTO;
import com.rnrsolutions.greenbless.face_recognition.entity.FaceRecognitionEntity;
import com.rnrsolutions.greenbless.face_recognition.repository.FaceRecognitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FaceRecognitionServiceImp implements FaceRecognitionService{
    @Autowired
    private FaceRecognitionRepository faceRecognitionRepository;

    @Value("${firebase.storage.bucketName}")
    private String bucketName;

    @Override
    public String uplaod(MultipartFile multipartFile) throws Exception {
        try {
            String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
            LocalDateTime currentDateTime = LocalDateTime.now();

            // Save image to Firebase Storage
            String savedFileName = saveImageToFirebaseStorage(multipartFile);

            // Save other details to MySQL
            FaceRecognitionEntity entityObject = new FaceRecognitionEntity(fileName,  (currentDateTime.toString() + "_" + fileName),currentDateTime);

            faceRecognitionRepository.save(entityObject);

            return "Successfully Inserted!";
        } catch (Exception e) {
            return ("Could not save File: " + e.getMessage());
        }
    }

    @Override
    public String saveData(String fileName, String recognizedNames, String nextAction)throws Exception{
        try {
            FaceRecognitionEntity entityObject1 = new FaceRecognitionEntity(fileName, recognizedNames, nextAction);
            faceRecognitionRepository.save(entityObject1);
            return "Successfully Saved Data";
        }catch (Exception e){
            return "Could not Save Data";
        }
    }


    @Override
    public List<FaceRecognitionEntity> getAllData() {
        return faceRecognitionRepository.findAll();
    }

//    @Override
//    public List<String> getFilteredData() {
//        return faceRecognitionRepository.findByNextActionAndRecognizedNamesIsNullEmpty("Anjali")
//                .stream()
//                .collect(Collectors.toList());
//    }

    public String saveImageToFirebaseStorage(MultipartFile multipartFile) throws Exception {
        try {
            String fileName = multipartFile.getOriginalFilename();
            assert fileName != null;
            fileName = fileName.replaceAll("\\s+", "_");
            File file = convertToFile(multipartFile, fileName);
            String tempUrl = uploadImage(file, fileName);
            file.delete();
            return "Successfully Uploaded! URL: " + tempUrl;
        } catch (Exception e) {
            e.printStackTrace();
            return "Unsuccessfully Uploaded! Error: " + e.getMessage();
        }
    }

    @Override
    public String uploadImage(File file, String fileName) throws IOException {
        Credentials credentials = GoogleCredentials.fromStream(new FileInputStream("D:\\Sandun\\6 All\\All\\MainApplication\\src\\main\\resources\\face-app-604bc-firebase-adminsdk-nl0o5-cca3d57dd4.json"));
        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
        String encodedFileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8).replaceAll("\\+", "%20");
        BlobId blobId = BlobId.of("face-app-604bc.appspot.com" , encodedFileName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("image/jpeg").build();
        storage.create(blobInfo, Files.readAllBytes(file.toPath()));
        return String.format("https://firebasestorage.googleapis.com/v0/b/face-app-604bc.appspot.com/o/%s?alt=media", encodedFileName);
    }

    private File convertToFile(MultipartFile multipartFile, String fileName) throws IOException {
        File tempFile = new File(System.getProperty("java.io.tmpdir") + "/" + fileName);
        multipartFile.transferTo(tempFile);
        return tempFile;
    }

}
