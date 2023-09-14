package com.tickets.tickets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
public class ApiController {

    @Autowired
    private PriceService priceService;

    // Constructor to set up the PriceService bean
    public ApiController(PriceService priceService) {
        this.priceService = priceService;
    }
    @PostMapping("/processJson")
    public Result processJson(@RequestBody List<Input> inputList) {
        double basePrice = priceService.getBasePriceFromUrl();
        double taxPercentage = priceService.getTaxPercentageFromUrl();
        List<Ticket> ticketDetails  = new ArrayList<Ticket>();
        double total = 0;
        for (Input input : inputList) {
            if (input.getIsAdult()) {
                double price = TicketCalculator.calculateAdultTicket(basePrice,taxPercentage);
                ticketDetails .add(new Ticket(TicketFormatter.formatAdultTicketString(price,basePrice,taxPercentage),price));
                total = total+price;
            } else {
                double price = TicketCalculator.calculateChildTicket(basePrice,taxPercentage);
                ticketDetails.add(new Ticket(TicketFormatter.formatChildTicketString(price,basePrice,taxPercentage),price));
                total = total+price;
            }
            if(input.getBags() > 0 && input.getBags() < 1000 ) {
                double price = TicketCalculator.calculateLuggagePrice(input.getBags(),basePrice,taxPercentage);
                ticketDetails.add(new Ticket(TicketFormatter.formatLuggagePriceString(input.getBags(), price,basePrice,taxPercentage),price));
                total = total+price;
            } else if(input.getBags() >= 1000) {
                ticketDetails.add(new Ticket("Luggage amount exceeds the limit.",0));
            }
        }
        return new Result(ticketDetails, Math.round(total * 100.0) / 100.0);
    }
}
