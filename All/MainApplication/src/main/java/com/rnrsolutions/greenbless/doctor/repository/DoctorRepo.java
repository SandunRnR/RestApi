package com.rnrsolutions.greenbless.doctor.repository;

import com.rnrsolutions.greenbless.doctor.entity.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepo extends JpaRepository<DoctorEntity,Integer> {

}
