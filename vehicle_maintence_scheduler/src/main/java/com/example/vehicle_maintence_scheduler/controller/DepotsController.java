package com.example.vehicle_maintence_scheduler.controller;

import com.example.vehicle_maintence_scheduler.service.DepotsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepotsController {

    private final DepotsService depotsService;

    public DepotsController(DepotsService depotsService) {
        this.depotsService = depotsService;
    }

    @GetMapping("/depots")
    public String getDepots() {
        return depotsService.getDepots();
    }

    @GetMapping("/vehicles")
    public String getVehicles() {
        return depotsService.getVehicles();
    }
}
