package com.company.SummativeProject;

import com.company.SummativeProject.controller.quoteController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@RunWith(SpringRunner.class)
@WebMvcTest(quoteController.class)
public class quoteControllerTest {
    // Wiring in the Mockmvc
    @Autowired
    private MockMvc mockMvc;

    // ObjectMapper used to convert Java into JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() {
        // To initialize the `wordsDictionary` before each test
        quoteController controller = new quoteController();
    }
    // Testing POST
    @Test
    public void shouldReturnQuote() throws Exception {
        quoteController quoteObject = new quoteController();
        String output = mapper.writeValueAsString(quoteObject);
        mockMvc.perform(MockMvcRequestBuilders.get("/quote")).andDo(print()).andExpect(status().isOk());
    }
}
