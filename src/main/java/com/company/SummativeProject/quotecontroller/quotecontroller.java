package com.company.SummativeProject.quotecontroller;

import com.company.SummativeProject.models.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@RestController
public class quotecontroller {

    List<Quote> quotes = new ArrayList<Quote>();
    public quotecontroller() {

        // Quotes
        Quote quote1 = new Quote(1, "J.R.R. Tolkien", "All that is gold does not glitter, not all those who wander are lost.");
        Quote quote2 = new Quote(2, "Forrest Gump", "Life is like a box of chocolates, you never know what you're gonna get.");
        Quote quote3 = new Quote(3, "André Gide", "It is better to be hated for what you are than to be loved for what you are not.");
        Quote quote4 = new Quote(4,"Ralph Waldo Emerson", "To be yourself in a world that is constantly trying to make you something else is the greatest accomplishment.");
        Quote quote5 = new Quote(5,"Maya Angelou", "There is no greater agony than bearing an untold story inside you.");
        Quote quote6 = new Quote(6, "Mahatma Gandhi", "Be the change you wish to see in the world." );
        Quote quote7 = new Quote(7,"J.K. Rowling", "It does not do to dwell on dreams and forget to live." );
        Quote quote8 = new Quote(8, "Eleanor Roosevelt", "No one can make you feel inferior without your consent.");
        Quote quote9 = new Quote(9, "Albert Einstein", "I am enough of an artist to draw freely upon my imagination. Imagination is more important than knowledge.");
        Quote quote10 = new Quote(10, "Robert Frost", "In three words I can sum up everything I've learned about life: it goes on.");


        this.quotes.add(quote1);
        this.quotes.add(quote2);
        this.quotes.add(quote3);
        this.quotes.add(quote4);
        this.quotes.add(quote5);
        this.quotes.add(quote6);
        this.quotes.add(quote7);
        this.quotes.add(quote8);
        this.quotes.add(quote9);
        this.quotes.add(quote10);



    }
    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Quote quoteAPI() {
        Random r = new Random();
        int sol = r.nextInt(10) + 1;
        for (Quote quote : this.quotes) {
            if (quote.getId() == sol) return quote;
        }
        return null;
    }

}
