package com.company.SummativeProject;

import static org.hamcrest.Matchers.startsWith;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.company.SummativeProject.controller.wordController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(wordController.class)
public class wordControllerTest {

    @Autowired
    private MockMvc mvc;

    @Before
    public void setUp() {
        // To initialize the `wordsDictionary` before each test
        wordController controller = new wordController();
        controller.populateDictionary();
    }

    @Test
    public void getRandomWord_returnsRandomWord() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/word").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string(startsWith("The Word of the Day is:")));
    }
}
