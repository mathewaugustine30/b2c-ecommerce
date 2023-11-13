package com.ecommerce.service;

import com.ecommerce.entity.Plant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlantService {
    private static List<Plant> plants = new ArrayList<>();
    public List<Plant> getAll() {
        return plants;
    }

    public int addPlant(Plant plant) {

        if (plants.contains(plant)) {
            System.out.println("found a duplicate");
            return -1;
        }
        plants.add(plant);
        return 0;
    }
}
