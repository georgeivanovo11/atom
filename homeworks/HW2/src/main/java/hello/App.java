package hello;

import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class App {

    public static void main(String[] args) throws IOException {
        String path = "dictionary.txt";
        int maxAttempts = 10;

        ArrayList<String> words = FileService.getDictionary(path);
        String randomWord = Helper.getRandomWord(words);

        System.out.println("Welcome to Bulls and Cows game!");
        System.out.println("I offered a " + randomWord.length() + "-letter word, your guess?");

        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));

        int attempts = 0;
        String assumption;

        do {
            assumption = reader.readLine();
            if (assumption.equals(randomWord)) {
                break;
            }
            HashMap<String, Integer> result = Engine.calculate(assumption, randomWord);
            System.out.println("Cows: " + result.get("cows") + ". Bulls: " + result.get("bulls"));
            System.out.println("Please type another word");
            attempts++;
        } while (attempts < maxAttempts);

        if (attempts == maxAttempts) {
            System.out.println("You lose!");
        } else {
            System.out.println("You win!");
        }

    }
}
