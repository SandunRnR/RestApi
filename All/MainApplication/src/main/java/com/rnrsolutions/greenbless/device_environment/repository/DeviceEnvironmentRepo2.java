package com.rnrsolutions.greenbless.device_environment.repository;

import com.rnrsolutions.greenbless.device_environment.entity.DeviceEnvironmentEntity2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceEnvironmentRepo2 extends JpaRepository<DeviceEnvironmentEntity2, Integer> {
    void deleteById(int id);

    List<DeviceEnvironmentEntity2> findAll();

}
