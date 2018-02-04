package com.example;

public class JokeSmith {

    private int counter = -1;

    String[] jokes = {  "1. ",
                        "2. ",
                        "3. ",
                        "4. ",
                        "5. ",
                        "6. ",
                        "7. ",
    };

    public String[] getJokes() {
        return jokes;
    }

    public String getaJoke() {
        counter++;
        if (getJokes().length == counter) {
            counter = 0;
        }
        return getJokes()[counter];
    }

    public String getCurrentJoke() {
        return getJokes()[counter];
    }

}
