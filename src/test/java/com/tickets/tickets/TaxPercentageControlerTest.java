package com.tickets.tickets;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringJUnitConfig
@WebMvcTest(TaxPercentageControler.class)
public class TaxPercentageControlerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetTaxPercentage() throws Exception {
        double expectedTaxPercentage = TicketConstants.TAX_PERCENTAGE;

        mockMvc.perform(MockMvcRequestBuilders.get("/api/tax-percentage")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(String.valueOf(expectedTaxPercentage)));
    }
}

