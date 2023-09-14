package com.tickets.tickets;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TicketCalculatorTest {
    private double basePrice = 10.0;
    private double taxPercentage = 21.0;
    @Test
    public void testCalculateAdultTicket() {
        double expectedPrice = 12.10; // Replace with the expected value
        double actualPrice = TicketCalculator.calculateAdultTicket(basePrice, taxPercentage);
        assertEquals(expectedPrice, actualPrice, 0.001);
    }

    @Test
    public void testCalculateChildTicket() {
        double expectedPrice = 6.05; // Replace with the expected value
        double actualPrice = TicketCalculator.calculateChildTicket(basePrice, taxPercentage);
        assertEquals(expectedPrice, actualPrice, 0.001);
    }

    @Test
    public void testCalculateLuggagePrice() {
        int quantity = 2; // Replace with the desired quantity
        double expectedPrice = 7.26; // Replace with the expected value
        double actualPrice = TicketCalculator.calculateLuggagePrice(quantity, basePrice, taxPercentage);
        assertEquals(expectedPrice, actualPrice, 0.001);
    }
}

