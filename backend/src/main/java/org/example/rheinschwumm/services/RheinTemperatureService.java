package org.example.rheinschwumm.services;

import org.example.rheinschwumm.apis.OpenDataBaselStadtApi;
import org.example.rheinschwumm.models.RheinTemperature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RheinTemperatureService {
    private final OpenDataBaselStadtApi openDataBaselStadtApi;

    @Autowired
    public RheinTemperatureService(OpenDataBaselStadtApi openDataBaselStadtApi) {
        this.openDataBaselStadtApi = openDataBaselStadtApi;
    }

    public RheinTemperature getRheinTemperature() {
        return openDataBaselStadtApi.getRheinTemperature();
    }
}
