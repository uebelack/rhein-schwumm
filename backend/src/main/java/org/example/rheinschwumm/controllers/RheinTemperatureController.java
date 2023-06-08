package org.example.rheinschwumm.controllers;


import org.example.rheinschwumm.models.RheinTemperature;
import org.example.rheinschwumm.services.RheinTemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RheinTemperatureController {

    private final RheinTemperatureService rheinTemperatureService;

    @Autowired
    public RheinTemperatureController(RheinTemperatureService rheinTemperatureService) {
        this.rheinTemperatureService = rheinTemperatureService;
    }

    @GetMapping("/api/rhein-temperature")
    public RheinTemperature getRheinTemperature() {
        return rheinTemperatureService.getRheinTemperature();
    }
}
