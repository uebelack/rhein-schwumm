package org.example.rheinschwumm.apis;

import org.example.rheinschwumm.exceptions.OpenDataBaselStadtApiException;
import org.example.rheinschwumm.models.RheinTemperature;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class OpenDataBaselStadtApiTest {

    @Autowired
    OpenDataBaselStadtApi openDataBaselStadtApi;

    @Test
    void getRheinTemperature() throws OpenDataBaselStadtApiException {
        // RheinTemperature rheinTemperature = openDataBaselStadtApi.getRheinTemperature();
        // assertNotNull(rheinTemperature);
        // assertNotNull(rheinTemperature.timestamp());
        // assertNotNull(rheinTemperature.temperature());
        // System.out.println(rheinTemperature.temperature());
    }
}