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
    private String fileName;
    private String savedFileName;
    private LocalDateTime uploadDateAndTime;

    @Column(name = "recognized_names")
    private String recognizedNames;
    @Column(name = "next_action")
    private String nextAction;



    public FaceRecognitionEntity(String pFileName,String pSavedFileName,LocalDateTime pUploadDateAndTime,String nextAction){
        this.fileName = pFileName;
        this.savedFileName = pSavedFileName;
        this.uploadDateAndTime = pUploadDateAndTime;
        this.nextAction = nextAction;
    }

    public FaceRecognitionEntity(String fileName, String recognizedNames, String nextAction) {

        this.fileName = fileName;
        this.recognizedNames = recognizedNames;
        this.nextAction = nextAction;
    }
}
