package com.rnrsolutions.greenbless.device_environment.repository;

import com.rnrsolutions.greenbless.device_environment.entity.DeviceStateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceStateRepo extends JpaRepository<DeviceStateEntity,Integer> {

}
