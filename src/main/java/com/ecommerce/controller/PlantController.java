package com.ecommerce.controller;

import com.ecommerce.entity.Plant;
import com.ecommerce.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/plant")
public class PlantController implements PlantApi {
    @Autowired
    private PlantService service;

    @Override
    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<List<Plant>> getAll() {
        List<Plant> plants = service.getAll();
        return ResponseEntity.ok(plants);
    }

    @Override
    @PostMapping
    public ResponseEntity<Void> addPlant(Plant plant) {
        int result = service.addPlant(plant);
        if (result == -1)
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
