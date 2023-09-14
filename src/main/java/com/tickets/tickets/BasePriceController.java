package com.tickets.tickets;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/base-price")
public class BasePriceController {

    @GetMapping
    public double getBasePrice(
            @RequestParam("country") String country,
            @RequestParam("city") String city
    ) {
        if ("Lithuania".equals(country) && "Vilnius".equals(city)) {
            return TicketConstants.BASE_PRICE;
        } else {
            return 10.0; // Default base price
        }
    }
}