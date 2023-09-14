package com.tickets.tickets;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ResultTest {

    @Test
    public void testGetTickets() {
        List<Ticket> tickets = new ArrayList<>();
        Result result = new Result(tickets, 25.0);

        assertEquals(tickets, result.getTickets());
    }

    @Test
    public void testSetTickets() {
        List<Ticket> tickets = new ArrayList<>();
        Result result = new Result(new ArrayList<>(), 25.0);
        result.setTickets(tickets);

        assertEquals(tickets, result.getTickets());
    }

    @Test
    public void testGetTotal() {
        Result result = new Result(new ArrayList<>(), 25.0);

        assertEquals(25.0, result.getTotal(), 0.001); // You may adjust the delta as needed
    }

    @Test
    public void testSetTotal() {
        Result result = new Result(new ArrayList<>(), 0.0);
        result.setTotal(50.0);

        assertEquals(50.0, result.getTotal(), 0.001); // You may adjust the delta as needed
    }

    @Test
    public void testEquals() {
        List<Ticket> tickets1 = new ArrayList<>();
        List<Ticket> tickets2 = new ArrayList<>();

        Result result1 = new Result(tickets1, 25.0);
        Result result2 = new Result(tickets2, 25.0);

        assertTrue(result1.equals(result2));
    }

    @Test
    public void testNotEquals() {
        List<Ticket> tickets1 = new ArrayList<>();
        List<Ticket> tickets2 = new ArrayList<>();

        Result result1 = new Result(tickets1, 25.0);
        Result result2 = new Result(tickets2, 50.0);

        assertFalse(result1.equals(result2));
    }
}
