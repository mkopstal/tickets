package com.tickets.tickets;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TicketConstantsTest {

    @Test
    public void testBasePrice() {
        assertEquals(10.0, TicketConstants.BASE_PRICE, 0.001);
    }

    @Test
    public void testChildDiscountPercentage() {
        assertEquals(50.0, TicketConstants.CHILD_DISCOUNT_PERCENTAGE, 0.001);
    }

    @Test
    public void testLuggageDiscountPercentage() {
        assertEquals(30.0, TicketConstants.LUGGAGE_DISCOUNT_PERCENTAGE, 0.001);
    }

    @Test
    public void testTaxPercentage() {
        assertEquals(21.0, TicketConstants.TAX_PERCENTAGE, 0.001);
    }
}

