package com.company.SummativeProject.models;

import java.lang.reflect.Array;

public class Words {

    private int id;
    private String word;
    private String definition;

    public Words(int id, String word, String definition) {
        this.id = id;
        this.word = word;
        this.definition = definition;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    @Override
    public String toString() {
        return word;
    }

    public int getId() {
        return id;
    }
}
