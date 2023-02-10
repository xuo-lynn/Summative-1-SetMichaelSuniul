package com.company.SummativeProject.controller.quotecontroller;

import com.company.SummativeProject.controller.answercontroller.answercontroller;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class quotecontrollerTest {
    // Wiring in the Mockmvc
    @Autowired
    private MockMvc mockMvc;

    // ObjectMapper used to convert Java into JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    // For testing
    private List<answercontroller> answerList;

    @Before
    public void setUp() {
        // tbd
    }
    // Testing POST
    @Test
    public void shouldReturnQuote() throws Exception {
        quotecontroller quoteObject = new quotecontroller();
        String output = mapper.writeValueAsString(quoteObject);
        mockMvc.perform(get("/quote")).andDo(print()).andExpect(status().isOk());
    }
}