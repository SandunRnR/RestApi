package com.rnrsolutions.greenbless.face_recognition.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class FaceRecognitionDTO {

    private int id;

    private String fileName;
    private String savedFileName;
    private LocalDateTime uploadDateAndTime;

    private String recognized_names;
    private String next_action;

    public FaceRecognitionDTO(int id, String fileName, String recognizedNames, String nextAction) {
        this.fileName = fileName;
        this.recognized_names=recognizedNames;
        this.next_action = nextAction;
    }
}
