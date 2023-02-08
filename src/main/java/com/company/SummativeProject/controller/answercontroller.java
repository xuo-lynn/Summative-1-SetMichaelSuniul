package com.company.SummativeProject.controller;

import com.company.SummativeProject.models.Answer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@RestController
public class answercontroller {
    List<Answer> answers = new ArrayList<>();

    public answercontroller() {
        Answer answer1 = new Answer(1, "I was at the grocery store.");
        Answer answer2 = new Answer(2, "I am doing well.");
        Answer answer3 = new Answer(3, "My favorite meal is lunch.");
        Answer answer4 = new Answer(4,"My favorite color is green.");
        Answer answer5 = new Answer(5,"My favorite holiday is Thanksgiving.");
        Answer answer6 = new Answer(6, "My favorite time of day is the evening.");

        this.answers.add(answer1);
        this.answers.add(answer2);
        this.answers.add(answer3);
        this.answers.add(answer4);
        this.answers.add(answer5);
        this.answers.add(answer6);
    }

    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public String magic8Ball(@RequestBody Answer question) {
        Random r = new Random();
        int sol = r.nextInt(6 ) + 1;
        for (Answer ans : this.answers) {
            if (ans.getId() == sol) return ans.getAnswer();
        }
        return null;
    }
}
