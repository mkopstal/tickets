package com.tickets.tickets;
import com.tickets.tickets.TicketConstants;
import com.tickets.tickets.BasePriceController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BasePriceControllerTest {

    @Autowired
    private BasePriceController basePriceController;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(basePriceController).build();
    }

    @Test
    public void testGetBasePriceWithValidCountryAndCity() throws Exception {
        String country = "Lithuania";
        String city = "Vilnius";

        mockMvc.perform(get("/api/base-price")
                        .param("country", country)
                        .param("city", city))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(Double.toString(TicketConstants.BASE_PRICE))));
    }

    @Test
    public void testGetBasePriceWithInvalidCountryOrCity() throws Exception {
        String country = "InvalidCountry";
        String city = "InvalidCity";

        mockMvc.perform(get("/api/base-price")
                        .param("country", country)
                        .param("city", city))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("10.0"))); // Default base price
    }
}
