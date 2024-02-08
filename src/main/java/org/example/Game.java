/**
 * Создал Андрей Антонов 2/7/2024 1:17 PM.
 **/

package org.example;

import java.util.Scanner;

public class Game  {
    private final HandmanDrawer hangmanDrawer = new HandmanDrawer();
    private final RandomWordSelector wordSelector = new RandomWordSelector();
    private final WorkMaskOperator maskOperator = new WorkMaskOperator();

    public void start() {
        Scanner scanner = new Scanner(System.in);
        String option;
        int mistakesCount;

        while (true) {
            System.out.println("Menu: [N]ew game / [E]xit");
            option = scanner.nextLine();

            if (option.equalsIgnoreCase("N")) {
                mistakesCount = 0;
                maskOperator.cleaBuffer();
                hangmanDrawer.clearDrawing();
                String letter;
                String guessedWord = wordSelector.getRandomlySelectedWord();
                maskOperator.setWord(guessedWord);
                System.out.println("A random word been guessed.");
                maskOperator.printMask();

                while (!maskOperator.userWon()) {
                    System.out.println("Guess a letter");
                    letter = scanner.nextLine();
                    if (maskOperator.letterAlreadyUsed(letter)) {
                        System.out.printf("You have already used the letter '%s'\n", letter);
                    } else {
                        maskOperator.useUserInputLetter(letter);
                        if (maskOperator.containsLetter(letter)) {
                            System.out.println("You guessed");
                            System.out.print("Word: ");
                            maskOperator.updateMask(letter);
                            maskOperator.printMask();
                        } else {
                            System.out.println("You didn't guess! ");
                            mistakesCount++;
                            System.out.printf("Number of mistakes: %s/5\n", mistakesCount);
                            hangmanDrawer.updateHangmanDrawingMatrix(mistakesCount);
                            hangmanDrawer.printHangman();
                        }
                    }

                    if (mistakesCount==5) {
                        System.out.println("You lose!");
                        System.out.printf("The word you had guess: %s ", guessedWord);
                        break;
                    } else if (maskOperator.userWon()) {
                        System.out.println("You won! Congratulations!");
                    }
                }
            } else if (option.equalsIgnoreCase("E")) {
                System.out.println("Existing the game");
                System.exit(0);
            } else {
                System.out.println("You enter an incorrect input: Try again!");
            }
        }
    }
}
