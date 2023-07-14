package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class View {

    private String word;
    private List<String> gibbets = Arrays.asList(
            "   ========\n",
            "        |\n        |\n        |\n        |\n        |\n   ========\n",
            "    +---+\n        |\n        |\n        |\n        |\n        |\n   ========\n",
            "    +---+\n    |   |\n    O   |\n        |\n        |\n        |\n   ========\n"
    );

    public View(String word) {
        this.word = word;
    }

    public void word() {
        System.out.printf(
                "+---+---+---+\n" +
                        "| %s | %s | %s |\n" +
                        "+---+---+---+\n", word.charAt(0), word.charAt(1), word.charAt(2)
        );
    }

    public void gibbet() {
        System.out.println(
                "    +---+\n" +
                        "    |   |\n" +
                        "    O   |\n" +
                        "        |\n" +
                        "        |\n" +
                        "        |\n" +
                        "   ========\n"
        );
    }

    public void testGibbets() {
        gibbets.forEach(System.out::println);
    }

//    public void nextStep() {
//        System.out.println("Введите букву: \n");
//    }

    public void hello() {
        System.out.println("Игра началась!");
    }

}
