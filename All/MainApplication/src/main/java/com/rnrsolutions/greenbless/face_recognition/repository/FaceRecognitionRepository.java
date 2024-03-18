package com.rnrsolutions.greenbless.face_recognition.repository;

import com.rnrsolutions.greenbless.face_recognition.entity.FaceRecognitionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FaceRecognitionRepository extends JpaRepository<FaceRecognitionEntity,Integer> {
//    @Query("SELECT f.fileName FROM FaceRecognitionEntity f WHERE f.nextAction = ?1 AND (f.recognizedNames IS NULL OR f.recognizedNames = '')")
//    List<String> findByNextActionAndRecognizedNamesIsNullEmpty(String nextAction);

}
