//package com.rnrsolutions.greenbless.doctorfileupload.entity;
//
//
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.time.LocalDateTime;
//
//@Entity
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//@Getter
//@Setter
//@Table(name = "DoctorFileUpload")
//public class DoctorFileUploadEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    private LocalDateTime uploadDateAndTime;
//    private String fileName;
//
//    public DoctorFileUploadEntity(
//            LocalDateTime pUploadDateTime,
//            String pFileName) {
//        this.uploadDateAndTime = pUploadDateTime;
//        this.fileName = pFileName;
//    }
//}
