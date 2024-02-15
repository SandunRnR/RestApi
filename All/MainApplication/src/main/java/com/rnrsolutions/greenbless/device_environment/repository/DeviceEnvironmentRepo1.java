package com.rnrsolutions.greenbless.device_environment.repository;

import com.rnrsolutions.greenbless.device_environment.entity.DeviceEnvironmentEntity1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DeviceEnvironmentRepo1 extends JpaRepository<DeviceEnvironmentEntity1, Integer> {
    void deleteById(int id);

    List<DeviceEnvironmentEntity1> findAll();

}
