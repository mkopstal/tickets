package com.tickets.tickets;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tax-percentage")
public class TaxPercentageControler {
    @GetMapping
    public double getBasePrice() {
        return TicketConstants.TAX_PERCENTAGE;
    }
}
