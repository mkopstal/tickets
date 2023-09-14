package com.tickets.tickets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PriceService {
    @Value("${service.base-price-url}")
    private String basePriceServiceUrl;

    @Value("${service.tax-percentage-url}")
    private String taxPercentageServiceUrl;



    @Autowired
    private RestTemplate restTemplate;

    public double getBasePriceFromUrl(String country,String city) {
        // Build the URL with query parameters
        String url = basePriceServiceUrl + "?country=" + country + "&city=" + city;
        ResponseEntity<Double> response = restTemplate.getForEntity(url, Double.class);
        return response.getBody();
    }

    public double getTaxPercentageFromUrl() {
        ResponseEntity<Double> response = restTemplate.getForEntity(taxPercentageServiceUrl, Double.class);
        return response.getBody();
    }
}