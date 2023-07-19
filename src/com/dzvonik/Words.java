package com.dzvonik;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class Words {

    private final String PATH = "words.txt";
    private List<String> words;

    public Words() {
        Path path = Paths.get(PATH);
        try {
            words = Files.readAllLines(path);
            words.replaceAll(s -> s.toLowerCase());;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getRandom() {
        return words.get(randomNumber(words.size() - 1));
    }

    public StringBuilder encryptWord(String word) {
        StringBuilder encryptedWord = new StringBuilder(word);

        for (int i = 0; i < word.length(); i++) {
            encryptedWord.setCharAt(i, 'x');
        }

        return encryptedWord;
    }

    private int randomNumber(int upperBound) {
        Random random = new Random();
        return random.nextInt(upperBound) + 1;
    }

}
