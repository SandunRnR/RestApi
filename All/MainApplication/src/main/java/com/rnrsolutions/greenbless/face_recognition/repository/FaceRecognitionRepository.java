package com.rnrsolutions.greenbless.face_recognition.repository;

import com.rnrsolutions.greenbless.face_recognition.entity.FaceRecognitionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FaceRecognitionRepository extends JpaRepository<FaceRecognitionEntity,Integer> {

    FaceRecognitionEntity findFirstByNextActionAndRecognizedNamesIsNull(String nextAction);


}
