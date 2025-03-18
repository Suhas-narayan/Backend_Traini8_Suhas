package com.project.assignment.registry.repository;

import com.project.assignment.registry.model.TrainingCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TrainingCenterRepository extends JpaRepository<TrainingCenter, Long>, JpaSpecificationExecutor<TrainingCenter> {
    boolean existsByCenterCode(String centerCode);
}