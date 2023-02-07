package com.company.SummativeProject.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class wordController {
    public HashMap<String, String> wordsDictionary = new HashMap<>();


    public void populateDictionary() {
        wordsDictionary.put("Hello", "A commonly used greeting");
        wordsDictionary.put("World", "Referring to the planet Earth");
        wordsDictionary.put("Java", "A programming language or a type of coffee");
        wordsDictionary.put("Spring", "A lukewarm floral season of the year or a framework in Java");
        wordsDictionary.put("Boot", "A piece of footwear or a framework in Java");
        wordsDictionary.put("Python", "A programming language or a large snake");
        wordsDictionary.put("C#", "A programming language or a musical note");
        wordsDictionary.put("Apple", "A company that makes computers or a fruit");
        wordsDictionary.put("Amazon", "A company that sells books or a river");
        wordsDictionary.put("Google", "A company that makes search engines or a number");
    }

    @GetMapping(value = "/word") //returns one word and its definition
    public String getWord() {
        populateDictionary();
        String word = "";
        String definition = "";
        for (String key : wordsDictionary.keySet()) {
            word = key;
            definition = wordsDictionary.get(key);
            break;
        }
        return "Word of the Day: " + word + ": " + definition;
    }
}
