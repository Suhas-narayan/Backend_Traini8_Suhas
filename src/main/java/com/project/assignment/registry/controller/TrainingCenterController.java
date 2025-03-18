package com.project.assignment.registry.controller;

import com.project.assignment.registry.model.TrainingCenter;
import com.project.assignment.registry.service.TrainingCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/training-centers")
@CrossOrigin(origins = "http://localhost:3000")
public class TrainingCenterController {

    @Autowired
    private TrainingCenterService trainingCenterService;

    @PostMapping
    public ResponseEntity<TrainingCenter> createTrainingCenter(@Valid @RequestBody TrainingCenter trainingCenter) {
        TrainingCenter createdCenter = trainingCenterService.createTrainingCenter(trainingCenter);
        return new ResponseEntity<>(createdCenter, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TrainingCenter>> getAllTrainingCenters(
            @RequestParam(required = false) Map<String, String> filters) {

        List<TrainingCenter> trainingCenters;


        if (filters != null && !filters.isEmpty()) {
            trainingCenters = trainingCenterService.getFilteredTrainingCenters(filters);
        } else {
            trainingCenters = trainingCenterService.getAllTrainingCenters();
        }

        return new ResponseEntity<>(trainingCenters, HttpStatus.OK);
    }
}



