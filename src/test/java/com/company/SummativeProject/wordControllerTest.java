package com.company.SummativeProject;

import com.company.SummativeProject.controller.quoteController;
import com.company.SummativeProject.controller.wordController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(wordController.class)
public class wordControllerTest {
    // Wiring in the Mockmvc
    @Autowired
    private MockMvc mockMvc;

    // ObjectMapper used to convert Java into JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    // Testing POST
    @Test
    public void shouldReturnQuote() throws Exception {
        wordController wordObject = new wordController();
        String output = mapper.writeValueAsString(wordObject);
        mockMvc.perform(get("/word")).andDo(print()).andExpect(status().isOk());
    }
}

