package com.company.SummativeProject.controller.answercontroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(answercontroller.class)
public class answercontrollerTest {
    // Wiring in the Mockmvc
    @Autowired
    private MockMvc mockMvc;

    // ObjectMapper used to convert Java into JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    // Testing POST
    @Test
    public void testMagic8Ball() throws Exception {
        answercontroller acObject = new answercontroller();

        // Convert Java Object to JSON
        String input = mapper.writeValueAsString(acObject);

        mockMvc.perform(post("/magic")
                .content(input)
                .contentType
                        (MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isCreated());
    }


}