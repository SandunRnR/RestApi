//package com.rnrsolutions.greenbless.doctorfileupload.service;
//
////import com.rnrsolutions.greenbless.ai_project.entity.AIEntity;
////import com.rnrsolutions.greenbless.ai_project.repository.AIRepository;
//import com.rnrsolutions.greenbless.doctorfileupload.entity.DoctorFileUploadEntity;
//import com.rnrsolutions.greenbless.doctorfileupload.repository.DoctorFIleUploadRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import org.springframework.util.StringUtils;
//import org.springframework.web.multipart.MultipartFile;
//import com.google.cloud.storage.Blob;
//import com.google.cloud.storage.Bucket;
//import com.google.firebase.cloud.StorageClient;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import org.springframework.util.StringUtils;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.time.LocalDateTime;
//import java.util.Date;
//import java.util.List;
//import java.util.stream.Collectors;
//
//
//@Service
//public class DoctorFileUploadServiceImp implements DoctorFileUploadService{
//
//    @Autowired
//    private DoctorFIleUploadRepository doctorFIleUploadRepository;
//
////    @Value("${upload.image.path}")
////    private String uploadImagePath;
//
//    @Value("${firebase.storage.bucket.name}")
//    private String bucketName;
//
//    @Override
//    public String uplaod(MultipartFile file) throws Exception {
//
//        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//        try {
//            if (fileName.contains("..")) {
//                throw new Exception("Filename contains invalid path sequence "
//                        + fileName);
//            }
//
//            LocalDateTime currentDateTime = LocalDateTime.now();
//
//            DoctorFileUploadEntity newObjectDoctorFileUpload = new DoctorFileUploadEntity(currentDateTime, fileName);
//
//            doctorFIleUploadRepository.save(newObjectDoctorFileUpload);
//
//            // Get a reference to the storage service
//            Bucket bucket = StorageClient.getInstance().bucket(bucketName);
//
//            // Generate unique filename
//            String uniqueFileName = new Date().getTime() + "_" + fileName;
//
//            // Upload file to Firebase Storage
//            Blob blob = bucket.create(uniqueFileName, file.getBytes(), file.getContentType());
//
//            return "Successfully Inserted!";
//        } catch (IOException e) {
//            throw new Exception("Could not save File: " + e.getMessage());
//        }
//    }
//
//
//    @Override
//    public List<String> getUploadedFiles() {
//        List<DoctorFileUploadEntity> uploadedFiles = doctorFIleUploadRepository.findAll();
//        return uploadedFiles.stream().map(DoctorFileUploadEntity::getFileName).collect(Collectors.toList());
//    }
//
//    @Override
//    public File getFile(String fileName) throws IOException {
//        List<DoctorFileUploadEntity> uploadedFiles = doctorFIleUploadRepository.findByFileName(fileName);
//        if (uploadedFiles.isEmpty()) {
//            throw new FileNotFoundException("File not found: " + fileName);
//        }
//        // Since we are using Firebase Storage, we don't need to retrieve files from local storage
//        throw new UnsupportedOperationException("getFile operation not supported for Firebase Storage");
//    }
//}
//
