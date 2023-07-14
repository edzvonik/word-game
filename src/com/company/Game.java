package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class Game {

    private int lifes;
    private List<String> words;
    private String word;
    private String pathToWords = "words.txt";
    private View view;

    public Game() {
        Path path = Paths.get(pathToWords);
        try {
            words = Files.readAllLines(path);
        } catch (IOException e) {
            System.out.println("File error!");
        }
        lifes = 4;
        word = words.get(getRandomNumber());
        view = new View(word);
    }

    public void start() {
        view.word();
        // view.gibbet();
        view.testGibbets();
        view.hello();
    }

    private int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(9) + 1;
    }

}
