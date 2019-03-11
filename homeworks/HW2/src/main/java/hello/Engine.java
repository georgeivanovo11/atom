package hello;


import java.util.HashMap;

public class Engine {
    static StringBuilder assumptionChars;
    static StringBuilder originChars;

    public static HashMap<String, Integer> calculate(String assumption, String origin) {
        assumptionChars = new StringBuilder(assumption);
        originChars = new StringBuilder(origin);
        Integer bulls = calculateBulls();
        Integer cows = calculateCows();
        return new HashMap<String, Integer>() {
            {
                put("bulls", bulls);
                put("cows", cows);
            }
        };

    }

    private static int calculateBulls() {
        int bullsCount = 0;

        for (int index = 0; index < assumptionChars.length(); index++) {
            if (index < originChars.length() && assumptionChars.charAt(index) == originChars.charAt(index)) {
                bullsCount++;
                assumptionChars.deleteCharAt(index);
                originChars.deleteCharAt(index);
                index--;
            }
        }

        return bullsCount;
    }

    private static int calculateCows() {
        int cowsCount = 0;

        for (int index = 0; index < assumptionChars.length(); index++) {
            for (int wordCharIndex = 0; wordCharIndex < originChars.length(); wordCharIndex++) {
                if (assumptionChars.charAt(index) == originChars.charAt(wordCharIndex)) {
                    cowsCount++;
                    assumptionChars.deleteCharAt(index);
                    originChars.deleteCharAt(wordCharIndex);
                    index--;
                    break;
                }
            }
        }

        return cowsCount;
    }
}
