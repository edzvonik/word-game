package com.dzvonik;

import java.util.Scanner;

public class Renderer {

    public void printStartGame(int mistakes, String currentWordState) {
        System.out.println("New game begin");
        printDelimiter();
        printGameState(mistakes, currentWordState);
    }

    public void printDelimiter() {
        System.out.println("+--+--+--+");
    }

    public void printExistLetter() {
        System.out.println("This letter already exist. Input other letter");
    }

    public void printLoseOrWin(int state) {
        if (state == -1) {
            System.out.println("You`re lose!");
        } else if (state == 1) {
            System.out.println("You`re win!");
        }
        printDelimiter();
    }

    public void printGameState(int mistakes, String currentWordState) {
        System.out.println("Mistakes (max 3): " + mistakes);
        System.out.println("Word: " + currentWordState);
    }

    public char getGuess() {
        System.out.print("Input letter: ");
        Scanner in = new Scanner(System.in);
        return in.next().charAt(0);
    }

    public String getInput() {
        Scanner in = new Scanner(System.in);
        System.out.println("New game?");
        System.out.println("Type \"start\" or \"exit\"");
        return in.nextLine();
    }

}
