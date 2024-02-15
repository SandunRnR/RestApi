package com.rnrsolutions.greenbless.ai_project.repository;

import com.rnrsolutions.greenbless.ai_project.entity.AIEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AIRepository extends JpaRepository<AIEntity, Integer> {

}
