package com.example.myjokelistapp;

public class Joke {
    private final String title;
    private final String setup;
    private final String punchline;

    public Joke(String title, String setup, String punchline) {
        this.title = title;
        this.setup = setup;
        this.punchline = punchline;
    }

    public String getTitle() { return title; }
    public String getSetup() { return setup; }
    public String getPunchline() { return punchline; }
}

