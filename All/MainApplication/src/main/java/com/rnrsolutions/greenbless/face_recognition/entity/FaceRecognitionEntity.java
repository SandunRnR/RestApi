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

    private String fileName;
    private String savedFileName;
    private LocalDateTime uploadDateAndTime;

    private String recognized_names;
    private String next_action;



    public FaceRecognitionEntity(String pFileName,String pSavedFileName,LocalDateTime pUploadDateAndTime){
        this.fileName = pFileName;
        this.savedFileName = pSavedFileName;
        this.uploadDateAndTime = pUploadDateAndTime;
    }

    public FaceRecognitionEntity(String fileName, String recognizedNames, String nextAction) {

        this.fileName = fileName;
        this.recognized_names = recognizedNames;
        this.next_action = nextAction;
    }
}
