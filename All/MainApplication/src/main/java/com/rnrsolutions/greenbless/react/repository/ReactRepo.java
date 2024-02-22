package com.rnrsolutions.greenbless.react.repository;

import com.rnrsolutions.greenbless.react.entity.ReactEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReactRepo extends JpaRepository<ReactEntity,Integer> {

}
