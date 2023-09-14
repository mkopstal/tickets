package com.tickets.tickets;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class ApiControllerTest {

    @InjectMocks
    private ApiController apiController;

    @Mock
    private PriceService priceService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testProcessJson() {
        // Mock the behavior of PriceService
        when(priceService.getBasePriceFromUrl("Lithuania","Vilnius")).thenReturn(10.0);
        when(priceService.getTaxPercentageFromUrl()).thenReturn(21.0);
        // Prepare test data
        List<Input> inputList = new ArrayList<>();
        Input input1 = new Input(true, 2);
        Input input2 = new Input(false, 0);
        inputList.add(input1);
        inputList.add(input2);

        Result result = apiController.processJson(inputList);

        List<Ticket> expectedTickets = new ArrayList<>();
        expectedTickets.add(new Ticket("Adult (10 EUR + 21%) = 12.10 EUR", 12.10));
        expectedTickets.add(new Ticket("Two bags (2 x 10 EUR  x 30% + 21%) = 7.26 EUR", 7.26));
        expectedTickets.add(new Ticket("Child (10 EUR  x 50% + 21%) = 6.05 EUR", 6.05));
        Result expectedResult = new Result(expectedTickets, 25.41);

        assertEquals(expectedResult,result);

    }
}
