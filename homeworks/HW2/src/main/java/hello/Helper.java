package hello;

import java.util.ArrayList;
import java.util.Random;

public class Helper {
    public static String getRandomWord(ArrayList<String> words) {
        return words.get(new Random().nextInt(words.size()));
    }
}
