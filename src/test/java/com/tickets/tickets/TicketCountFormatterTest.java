package com.tickets.tickets;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TicketCountFormatterTest {

    @Test
    public void testFormatBagCount() {
        // Test cases for formatBagCount(int bagCount, int hundredsCoeficient)

        // Test case 1: bagCount = 1, hundredsCoeficient = 0
        assertEquals("One bag (", TicketCountFormatter.formatBagCount(1, 0));

        // Test case 2: bagCount = 5, hundredsCoeficient = 2
        assertEquals("Five bags (205 x ", TicketCountFormatter.formatBagCount(5, 2));

        // Test case 3: bagCount = 15, hundredsCoeficient = 1
        assertEquals("Fifteen bags (115 x ", TicketCountFormatter.formatBagCount(15, 1));

        // Test case 4: bagCount = 23, hundredsCoeficient = 0
        assertEquals("Twenty Three bags (23 x ", TicketCountFormatter.formatBagCount(23, 0));

        // Test case 5: bagCount = 100, hundredsCoeficient = 0
        assertEquals("One hundred (100 x ", TicketCountFormatter.formatBagCount(100, 0));

        // Test case 6: bagCount = 345, hundredsCoeficient = 0
        assertEquals("Three hundred Forty Five bags (345 x ", TicketCountFormatter.formatBagCount(345, 0));

        // Test case 7: bagCount = 1234 (invalid)
        assertEquals("Invalid bag count", TicketCountFormatter.formatBagCount(1234, 0));
    }

    @Test
    public void testFormatBagCountWithoutHundredsCoeficient() {
        // Test cases for formatBagCount(int bagCount)

        // Test case 1: bagCount = 1
        assertEquals("One bag (", TicketCountFormatter.formatBagCount(1));

        // Test case 2: bagCount = 5
        assertEquals("Five bags (5 x ", TicketCountFormatter.formatBagCount(5));

        // Test case 3: bagCount = 15
        assertEquals("Fifteen bags (15 x ", TicketCountFormatter.formatBagCount(15));

        // Test case 4: bagCount = 23
        assertEquals("Twenty Three bags (23 x ", TicketCountFormatter.formatBagCount(23));

        // Test case 5: bagCount = 100
        assertEquals("One hundred (100 x ", TicketCountFormatter.formatBagCount(100));

        // Test case 6: bagCount = 345
        assertEquals("Three hundred Forty Five bags (345 x ", TicketCountFormatter.formatBagCount(345));

        // Test case 7: bagCount = 1234 (invalid)
        assertEquals("Invalid bag count", TicketCountFormatter.formatBagCount(1234));
    }
}

