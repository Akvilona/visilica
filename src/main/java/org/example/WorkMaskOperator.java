/**
 * Создал Андрей Антонов 2/7/2024 1:16 PM.
 **/

package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class WorkMaskOperator {
    private String word;
    private String[] mask;
    private final Set<String> usedLetters = new HashSet<>();
    private final Set<String> wordUniqueLetters = new HashSet<>();
    private int numberOfGuessedLetters = 0;

    public void setWord(String word) {
        this.word = word;
        this.mask = new String[word.length()];
        Arrays.fill(mask, "*");
        Collections.addAll(wordUniqueLetters, word.split(""));
    }

    public void printMask() {
        System.out.println(String.join("", mask));
    }

    public void updateMask(String letter) {
        for (int i = 0; i < word.length(); i++) {
            if (Character.toString(word.charAt(i)).equalsIgnoreCase(letter)) {
                mask[i] = letter;
            }
        }
        numberOfGuessedLetters++;
    }

    public boolean containsLetter(String letters) {
        return wordUniqueLetters.contains(letters);
    }

    public void useUserInputLetter(String letter) {
        usedLetters.add(letter);
    }

    public boolean letterAlreadyUsed(String letter) {
        return usedLetters.contains(letter);
    }

    public boolean userWon() {
        return numberOfGuessedLetters == wordUniqueLetters.size();
    }

    public void cleaBuffer() {
        usedLetters.clear();
        wordUniqueLetters.clear();
        numberOfGuessedLetters = 0;
    }
}
