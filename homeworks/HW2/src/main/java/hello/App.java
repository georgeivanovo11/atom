package hello;

import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import org.slf4j.LoggerFactory;


public class App {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws IOException {
        String path = "dictionary.txt";
        int maxAttempts = 10;

        ArrayList<String> words = FileService.getDictionary(path);
        String randomWord = Helper.getRandomWord(words);

        System.out.println("Welcome to Bulls and Cows game!");
        System.out.println("I offered a " + randomWord.length() + "-letter word, your guess?");
        log.info("Game started");

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
            log.info("One more attempt." + "Cows: " + result.get("cows") + ". Bulls: " + result.get("bulls"));

            attempts++;
        } while (attempts < maxAttempts);

        if (attempts == maxAttempts) {
            System.out.println("You lose!");
            log.info("Lose");

        } else {
            System.out.println("You win!");
            log.info("Win");
        }

    }
}
