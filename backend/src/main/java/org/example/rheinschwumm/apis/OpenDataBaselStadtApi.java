package org.example.rheinschwumm.apis;

import org.example.rheinschwumm.exceptions.OpenDataBaselStadtApiException;
import org.example.rheinschwumm.models.RheinTemperature;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.ZonedDateTime;

@Component
public class OpenDataBaselStadtApi {
    private static final String ENDPOINT = "https://data.bs.ch/api/records/1.0/search/?dataset=100046&q=&rows=1&sort=startzeitpunkt&facet=startzeitpunkt";

    @Value("${open-data-basel-stadt.api-key:}")
    private String apiKey;

    public RheinTemperature getRheinTemperature() throws OpenDataBaselStadtApiException {

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(ENDPOINT + "&apikey=" + apiKey))
                    .GET()
                    .build();

            // send the HTTP request asynchronously and handle the response
            HttpResponse<String> response
                    = client.send(request, HttpResponse.BodyHandlers.ofString());

            // wait for the response to complete and handle any errors
            if (response.statusCode() == 200) {
                JSONObject jsonObject = new JSONObject(response.body());
                JSONObject record = jsonObject.getJSONArray("records").getJSONObject(0);
                ZonedDateTime timestamp = ZonedDateTime.parse(record.getString("record_timestamp"));
                Double temperature = record.getJSONObject("fields").getDouble("rus_w_o_s3_te");
                return new RheinTemperature(timestamp, temperature);
            } else {
                throw new OpenDataBaselStadtApiException("Could not get Rhein temperature, got status code " + response.statusCode());
            }
        } catch (IOException e) {
            throw new OpenDataBaselStadtApiException("Could not get Rhein temperature", e);
        } catch (InterruptedException e) {
            throw new OpenDataBaselStadtApiException("Could not get Rhein temperature", e);
        }
    }
}
