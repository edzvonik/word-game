package com.dzvonik;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Renderer {

    private String word;
    private List<String> gibbets = Arrays.asList(
            "   ========\n",
            "        |\n        |\n        |\n        |\n        |\n   ========\n",
            "    +---+\n        |\n        |\n        |\n        |\n        |\n   ========\n",
            "    +---+\n    |   |\n    O   |\n        |\n        |\n        |\n   ========\n");
    private Map<String, String> phrases = Map.of(
            "hello", "Игра началась!",
            "next", "Введите букву: ",
            "gameover", "Игра окончена!");

    public Renderer(String word) {
        this.word = word;
    }

    public void word(String word) {
        System.out.printf(
                "+---+---+---+\n" +
                        "| %s | %s | %s |\n" +
                        "+---+---+---+\n",
                word.charAt(0), word.charAt(1), word.charAt(2));
    }

    public void gibbet() {
        System.out.println(
                "         \n" +
                        "         \n" +
                        "         \n" +
                        "         \n" +
                        "         \n" +
                        "         \n" +
                        "   ========\n");
    }

    public void hello() {
        System.out.println("Игра началась!");
    }

    public char getGuess() {
        System.out.println("Input letter: ");
        Scanner in = new Scanner(System.in);
        return (char) in.nextInt();
    }

}
