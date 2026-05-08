package com.example.vehicle_maintence_scheduler.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DepotsService {

    private final RestTemplate restTemplate;
    private final String depotsUrl;
    private final String vehiclesUrl;
    private final String bearerToken;

    public DepotsService(
            @Value("${external.api.depots-url}") String depotsUrl,
            @Value("${external.api.vehicles-url}") String vehiclesUrl,
            @Value("${external.api.token}") String bearerToken
    ) {
        this.restTemplate = new RestTemplate(); 
        this.depotsUrl = depotsUrl;
        this.vehiclesUrl = vehiclesUrl;
        this.bearerToken = bearerToken;
    }

    public String getDepots() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(bearerToken);
        HttpEntity<Void> request = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                depotsUrl,HttpMethod.GET,request,String.class
        );

        return response.getBody();
    }

    public String getVehicles() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(bearerToken);
        HttpEntity<Void> request = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                vehiclesUrl,HttpMethod.GET,request, String.class
        );

        return response.getBody();
    }
}
