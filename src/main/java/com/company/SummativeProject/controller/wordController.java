package com.company.SummativeProject.controller;
import com.company.SummativeProject.models.Words;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedHashMap;

@RestController
public class wordController {
    public LinkedHashMap<Words, String> wordsDictionary = new LinkedHashMap<>();


    public void populateDictionary() {
        wordsDictionary.put(new Words("[1] Hello"), "A greeting or a way to start a phone call");
        wordsDictionary.put(new Words("[2] World"), "Referring to the planet Earth");
        wordsDictionary.put(new Words("[3] Java"), "A programming language or a type of coffee");
        wordsDictionary.put(new Words("[4] Spring"), "A lukewarm floral season of the year or a framework in Java");
        wordsDictionary.put(new Words("[5] Boot"), "A piece of footwear or a framework in Java");
        wordsDictionary.put(new Words("[6] Python"), "A programming language or a large snake");
        wordsDictionary.put(new Words("[7] C#"), "A programming language or a musical note");
        wordsDictionary.put(new Words("[8] Apple"), "A company that makes computers or a fruit");
        wordsDictionary.put(new Words("[9] Amazon"), "A company that sells books or a river");
        wordsDictionary.put(new Words("[10] Google"), "A company that makes search engines or a number");

        //set id for each word
        int id = 1;
        for (Words word : wordsDictionary.keySet()) {
            word.setId(id);
            id++;
        }
    }

    //prints a random word and it's definition
    @GetMapping(value = "/word")
    public String getRandomWord() {
        populateDictionary();
        int random = (int) (Math.random() * wordsDictionary.size());
        String randomWord = wordsDictionary.keySet().toArray()[random].toString();
        String randomDefinition = wordsDictionary.get(wordsDictionary.keySet().toArray()[random]);
        return "The Word of the Day is: " + randomWord + ": " + randomDefinition;

    }
}
