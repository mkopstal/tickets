package com.tickets.tickets;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class InputTest {

    @Test
    public void testGetIsAdult() {
        Input input = new Input(true, 2);
        assertEquals(true, input.getIsAdult());
    }

    @Test
    public void testSetIsAdult() {
        Input input = new Input(true, 2);
        input.setAdult(false);
        assertEquals(false, input.getIsAdult());
    }

    @Test
    public void testGetBags() {
        Input input = new Input(true, 2);
        assertEquals(2, input.getBags());
    }
}
