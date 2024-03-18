package com.rnrsolutions.greenbless.face_recognition.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Table(name = "FaceRecognitionTable")
public class FaceRecognitionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "file_name")
    private String file_name;
    private String savedFileName;
    private LocalDateTime uploadDateAndTime;

    @Column(name = "recognized_names")
    private String recognizedNames;
    @Column(name = "next_action")
    private String nextAction;



    public FaceRecognitionEntity(String pFileName,String pSavedFileName,LocalDateTime pUploadDateAndTime){
        this.file_name = pFileName;
        this.savedFileName = pSavedFileName;
        this.uploadDateAndTime = pUploadDateAndTime;
    }

    public FaceRecognitionEntity(String fileName, String recognizedNames, String nextAction) {

        this.file_name = fileName;
        this.recognizedNames = recognizedNames;
        this.nextAction = nextAction;
    }
}
