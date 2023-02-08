package com.company.SummativeProject.controller;
import com.company.SummativeProject.models.Words;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class wordController {
    public HashMap<Words, String> wordsDictionary = new HashMap<>();


    public void populateDictionary() {
        wordsDictionary.put(new Words("Hello"), "A greeting or a way to start a phone call");
        wordsDictionary.put(new Words("World"), "Referring to the planet Earth");
        wordsDictionary.put(new Words("Java"), "A programming language or a type of coffee");
        wordsDictionary.put(new Words("Spring"), "A lukewarm floral season of the year or a framework in Java");
        wordsDictionary.put(new Words("Boot"), "A piece of footwear or a framework in Java");
        wordsDictionary.put(new Words("Python"), "A programming language or a large snake");
        wordsDictionary.put(new Words("C#"), "A programming language or a musical note");
        wordsDictionary.put(new Words("Apple"), "A company that makes computers or a fruit");
        wordsDictionary.put(new Words("Amazon"), "A company that sells books or a river");
        wordsDictionary.put(new Words("Google"), "A company that makes search engines or a number");
    }

    //prints a random word and it's definition
    @GetMapping(value = "/word")
    public String getRandomWord() {
        populateDictionary();
        int random = (int) (Math.random() * wordsDictionary.size());
        String randomDefinition = wordsDictionary.values().toArray()[random].toString();
        String randomWord = wordsDictionary.keySet().toArray()[random].toString();
        return "The Word of the Day is: '" + randomWord + ": " + randomDefinition+ "'";

    }
}
