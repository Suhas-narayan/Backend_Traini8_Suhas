package com.project.assignment.registry.service;

import com.project.assignment.registry.exception.ValidationException;
import com.project.assignment.registry.model.TrainingCenter;
import com.project.assignment.registry.repository.TrainingCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TrainingCenterService {

    @Autowired
    private TrainingCenterRepository trainingCenterRepository;

    public TrainingCenter createTrainingCenter(TrainingCenter trainingCenter) {
        if (trainingCenterRepository.existsByCenterCode(trainingCenter.getCenterCode())) {
            throw new ValidationException("Center code already exists");
        }

        return trainingCenterRepository.save(trainingCenter);
    }

    public List<TrainingCenter> getAllTrainingCenters() {
        return trainingCenterRepository.findAll();
    }

    public List<TrainingCenter> getFilteredTrainingCenters(Map<String, String> filters) {
        Specification<TrainingCenter> spec = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filters.containsKey("centerName")) {
                predicates.add(criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("centerName")),
                        "%" + filters.get("centerName").toLowerCase() + "%"
                ));
            }

            if (filters.containsKey("centerCode")) {
                predicates.add(criteriaBuilder.equal(
                        root.get("centerCode"),
                        filters.get("centerCode")
                ));
            }

            if (filters.containsKey("city")) {
                predicates.add(criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("address").get("city")),
                        "%" + filters.get("city").toLowerCase() + "%"
                ));
            }

            if (filters.containsKey("state")) {
                predicates.add(criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("address").get("state")),
                        "%" + filters.get("state").toLowerCase() + "%"
                ));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        return trainingCenterRepository.findAll(spec);
    }
}