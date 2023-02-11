package com.company.SummativeProject;

import com.company.SummativeProject.controller.answerController;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(answerController.class)
public class answerControllerTest {
    // Wiring in the Mockmvc
    @Autowired
    private MockMvc mockMvc;

    // ObjectMapper used to convert Java into JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    // Testing POST
    @Test
    public void testMagic8Ball() throws Exception {
        answerController acObject = new answerController();

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
