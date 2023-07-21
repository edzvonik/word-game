package com.dzvonik;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {

    private Words words;
    private Renderer renderer;
    private int mistakes;
    private String word;
    private StringBuilder currentWordState;
    private Map<Character, Boolean> usedLetters;

    public Game() {
        this.words = new Words();
        this.renderer = new Renderer();
        this.word = words.getRandom();
        this.currentWordState = words.encryptWord(word);
        this.mistakes = 0;
        this.usedLetters = initUsedLetters();
    }

    public void startGame() {
        initialize();
        String input = renderer.getInput();

        switch (input) {
            case "start":
                renderer.printStartGame(mistakes, currentWordState.toString());

                while (mistakes < 3) {
                    char inputLetter = renderer.getGuess();
                    renderer.printDelimiter();

                    if (usedLetters.get(inputLetter) == true) {
                        renderer.printExistLetter();
                        mistakes++;
                        inputLetter = renderer.getGuess();

                    }

                    makeGuess(inputLetter);
                    renderer.printGameState(mistakes, currentWordState.toString());

                    if (isGameOver() == -1 || isGameOver() == 1) {
                        renderer.printLoseOrWin(isGameOver());
                        startGame();
                    }
                }

                break;
            case "exit":
                System.out.println("You`re exit");
                break;
            default:
                break;
        }

    }

    private void initialize() {
        mistakes = 0;
        word = words.getRandom();
        currentWordState = words.encryptWord(word);
        usedLetters = initUsedLetters();
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

    public int isGameOver() {
        if (mistakes == 3) {
            return -1; // loss
        } else if (word.equals(currentWordState.toString())) {
            return 1; // win
        }

        return 0; // other
    }

    private Map<Character, Boolean> initUsedLetters() {
        Map<Character, Boolean> usedLetters = new HashMap<>();

        for (char c = 'a'; c < 'z'; c++) {
            usedLetters.put(c, false);
        }

        return usedLetters;
    }

    public List<Integer> findLetterOccurrences(String word, char letter) {
        List<Integer> occurrences = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                occurrences.add(i);
            }
        }

        return occurrences;
    }

}
