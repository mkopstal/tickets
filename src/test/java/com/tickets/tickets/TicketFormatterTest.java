package com.tickets.tickets;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TicketFormatterTest {

    private double basePrice = 10.0;
    private double taxPercentage = 21.0;

    @Test
    public void testFormatAdultTicketString() {
        double price = 12.10;
        String expected = "Adult (10 EUR + 21%) = 12.10 EUR";
        String result = TicketFormatter.formatAdultTicketString(price, basePrice, taxPercentage);
        assertEquals(expected, result);
    }

    @Test
    public void testFormatChildTicketString() {
        double price = 6.05;
        String expected = "Child (10 EUR  x 50% + 21%) = 6.05 EUR";
        String result = TicketFormatter.formatChildTicketString(price, basePrice, taxPercentage);
        assertEquals(expected, result);
    }

    @Test
    public void testFormatLuggagePriceString() {
        int bagCount = 2;
        double price = 7.26;
        String expected = "Two bags (2 x 10 EUR  x 30% + 21%) = 7.26 EUR";
        String result = TicketFormatter.formatLuggagePriceString(bagCount, price, basePrice, taxPercentage);
        assertEquals(expected, result);
    }
}

