package com.company.SummativeProject;

import com.company.SummativeProject.controller.quoteController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class quoteControllerTest {
    // Wiring in the Mockmvc
    @Autowired
    private MockMvc mockMvc;

    // ObjectMapper used to convert Java into JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    // Testing POST
    @Test
    public void shouldReturnQuote() throws Exception {
        quoteController quoteObject = new quoteController();
        String output = mapper.writeValueAsString(quoteObject);
        mockMvc.perform(get("/quote")).andDo(print()).andExpect(status().isOk());
    }
}
