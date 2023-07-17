package com.dzvonik;

public class Game {
    private int mistakes;
    private String word;
    private String currentWordState;

    public Game() {
        Words words = new Words();
        this.word = words.getRandom();
    }

}
