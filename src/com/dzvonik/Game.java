package com.dzvonik;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Game {

    private Renderer renderer;
    private int mistakes;
    private String word;
    private StringBuilder currentWordState;
    private Map<Character, Boolean> usedLetters;

    public Game() {
        Words words = new Words();
        this.renderer = new Renderer();
        this.word = words.getRandom();
        this.currentWordState = words.encryptWord(word);
        this.mistakes = 0;
        this.usedLetters = initUsedLetters();
    }

    public void startGame() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter \"start\" or \"exit\"");
        String input = in.nextLine();

        switch (input) {
            case "start":
                System.out.println(word);
                System.out.println("New game begin");
                System.out.println("+--+--+--+");
                printGameState();

                while (mistakes < 3) {
                    char inputLetter = renderer.getGuess();
                    System.out.println("+--+--+--+");

                    if (usedLetters.get(inputLetter) == true) {
                        System.out.println("This letter already exist. Input other letter");
                        mistakes++;
                        inputLetter = renderer.getGuess();
                        System.out.println("+--+--+--+");
                    }

                    makeGuess(inputLetter);
                    printGameState();
                    isGameOver();
                }

                break;

            case "exit":
                System.out.println("You`re exit");
                break;

            default:
                break;
        }
    }

    public void printGameState() {
        System.out.println("Mistakes (max 3): " + mistakes);
        System.out.println("Word: " + currentWordState);
    }

    public void makeGuess(char letter) {
        List<Integer> occurences = findLetterOccurrences(word, letter);

        if (occurences.size() == 0) {
            mistakes++;
        }

        for (Integer occurence : occurences) {
            currentWordState.setCharAt(occurence, letter);
        }

        usedLetters.put(letter, true);
    }

    public void isGameOver() {
        if (mistakes == 3) {
            System.out.println("Your loose!");
        } else if (word.equals(currentWordState.toString())) {
            System.out.println("You`re win!");
        }
    }

    private Map<Character, Boolean> initUsedLetters() {
        Map<Character, Boolean> usedLetters = new HashMap<>();

        for (char c = 'a'; c < 'z'; c++) {
            usedLetters.put(c, false);
        }

        return usedLetters;
    }

    public static List<Integer> findLetterOccurrences(String word, char letter) {
        List<Integer> occurrences = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                occurrences.add(i);
            }
        }

        return occurrences;
    }

}
