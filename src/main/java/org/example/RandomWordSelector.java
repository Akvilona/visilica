/**
 * Создал Андрей Антонов 2/7/2024 1:15 PM.
 **/

package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class RandomWordSelector {
    private String[] words;

    public RandomWordSelector() {
        populateWordsArrayFromFile();
    }

    public String getRandomlySelectedWord() {
        Random random = new Random();
        return words[random.nextInt(words.length)];
    }

    private void populateWordsArrayFromFile() {
        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Java\\visilica\\src\\main\\java\\org\\example\\words.txt")) ) {
            br.lines().forEach(sb::append); // word -> sb.append(word);
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String wordsSeparatedByCommaAndSpace = sb.toString();
        words = wordsSeparatedByCommaAndSpace.split(", ");
    }
}
