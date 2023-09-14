package com.tickets.tickets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PriceService {

    @Autowired
    private RestTemplate restTemplate;

    public double getBasePriceFromUrl() {
        String baseUrl = "http://localhost:8080/api/base-price";
        ResponseEntity<Double> response = restTemplate.getForEntity(baseUrl, Double.class);
        return response.getBody();
    }

    public double getTaxPercentageFromUrl() {
        String baseUrl = "http://localhost:8080/api/tax-percentage";
        ResponseEntity<Double> response = restTemplate.getForEntity(baseUrl, Double.class);
        return response.getBody();
    }
}