package com.rnrsolutions.greenbless.face_recognition.repository;

import com.rnrsolutions.greenbless.face_recognition.entity.FaceRecognitionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Repository
public interface FaceRecognitionRepository extends JpaRepository<FaceRecognitionEntity,Integer> {

    FaceRecognitionEntity findFirstByNextActionAndRecognizedNamesIsNull(String nextAction);

    FaceRecognitionEntity findByFileName(String file_name);

//    FaceRecognitionEntity findFirstByNextAction(String nextAction);


    Optional<FaceRecognitionEntity> findByIdAndNextAction(int id, String nextAction);

//    @Query("SELECT f FROM FaceRecognitionEntity f WHERE (f.nextAction IS NULL OR f.nextAction = '') OR f.nextAction = :nextAction")
//    FaceRecognitionEntity findFirstByNextActionAndRecognizedNamesIsNull(@Param("nextAction") String nextAction);


//    @Query("SELECT f FROM FaceRecognitionEntity f WHERE (f.nextAction IS NULL OR f.nextAction = '') OR f.nextAction = :nextAction")
//    FaceRecognitionEntity findFirstByNextActionAndRecognizedNamesIsNull(@Param("nextAction") String nextAction, Pageable pageable);


}
