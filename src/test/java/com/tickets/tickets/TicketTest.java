package com.tickets.tickets;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TicketTest {

    @Test
    public void testGetTicketText() {
        Ticket ticket = new Ticket("Sample Ticket", 15.0);

        assertEquals("Sample Ticket", ticket.getTicketText());
    }

    @Test
    public void testSetTicketText() {
        Ticket ticket = new Ticket("Initial Ticket", 10.0);
        ticket.setTicketText("Updated Ticket");

        assertEquals("Updated Ticket", ticket.getTicketText());
    }

    @Test
    public void testGetTicketPrice() {
        Ticket ticket = new Ticket("Sample Ticket", 25.0);

        assertEquals(25.0, ticket.getTicketPrice(), 0.001); // You may adjust the delta as needed
    }

    @Test
    public void testSetTicketPrice() {
        Ticket ticket = new Ticket("Sample Ticket", 10.0);
        ticket.setTicketPrice(20.0);

        assertEquals(20.0, ticket.getTicketPrice(), 0.001); // You may adjust the delta as needed
    }

    @Test
    public void testEquals() {
        Ticket ticket1 = new Ticket("Sample Ticket", 15.0);
        Ticket ticket2 = new Ticket("Sample Ticket", 15.0);

        assertTrue(ticket1.equals(ticket2));
    }

    @Test
    public void testNotEquals() {
        Ticket ticket1 = new Ticket("Ticket A", 10.0);
        Ticket ticket2 = new Ticket("Ticket B", 20.0);

        assertFalse(ticket1.equals(ticket2));
    }
}

