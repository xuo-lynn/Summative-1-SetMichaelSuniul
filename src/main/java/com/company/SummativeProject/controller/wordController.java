package com.company.SummativeProject.controller;
import com.company.SummativeProject.models.Quote;
import com.company.SummativeProject.models.Words;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class wordController {

    List<Words> words = new ArrayList<Words>();

    public wordController() {

        Words Hello = new Words(1, "Hello", "A greeting or a way to start a phone call");
        Words Goodbye = new Words(2, "World", "Referring to the planet Earth");
        Words ThankYou = new Words(3, "Java", "A programming language or a coffee");
        Words Please = new Words(4, "Spring", "A season or a framework");
        Words Sorry = new Words(5, "Boot", "A piece of footwear or a way to start a program");
        Words ExcuseMe = new Words(6, "Python", "A programming language or a large snake");
        Words Yes = new Words(7, "C#", "A programming language or a musical note");
        Words No = new Words(8, "Apple", "A company that makes phones or a fruit ");
        Words I = new Words(9, "Amazon", "A company that sells everything or a river");
        Words You = new Words(10, "Google", "A company that knows everything or a verb");

        words.add(Hello);
        words.add(Goodbye);
        words.add(ThankYou);
        words.add(Please);
        words.add(Sorry);
        words.add(ExcuseMe);
        words.add(Yes);
        words.add(No);
        words.add(I);
        words.add(You);
    }
    @GetMapping(value = "/word")
    @ResponseStatus(value = HttpStatus.OK)
    public Words getRandomWord() {
            Random r = new Random();
            int sol = r.nextInt(10) + 1;
            for (Words word : this.words) {
                if (word.getId() == sol) return word;
            }
            return null;
        }
}