//package com.rnrsolutions.greenbless.doctorfileupload.controller;
//
//import com.rnrsolutions.greenbless.doctorfileupload.service.DoctorFileUploadService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/v1/doctorFileUpload")
//public class DoctorFileUpload {
//    @Autowired
//    private DoctorFileUploadService doctorFileUploadService;
//
//    @PostMapping("/docFile")
//    public String docUploadFile(
//            @RequestParam("file") MultipartFile pFile) throws Exception {
//
//        return doctorFileUploadService.uplaod(pFile);
//    }
//
//
//    @GetMapping("/docFiles")
//    public ResponseEntity<List<String>> getUploadedFiles() {
//        List<String> files = doctorFileUploadService.getUploadedFiles();
//        return ResponseEntity.ok(files);
//    }
//
//    @GetMapping("/docFile/{fileName}")
//    public ResponseEntity<byte[]> getFile(@PathVariable String fileName) throws IOException {
//        File file = doctorFileUploadService.getFile(fileName);
//        Path path = Paths.get(file.getAbsolutePath());
//        byte[] data = Files.readAllBytes(path);
//        return ResponseEntity.ok().body(data);
//    }
//
//}
