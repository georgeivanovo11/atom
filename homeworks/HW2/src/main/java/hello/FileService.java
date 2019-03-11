package hello;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class FileService {

    public static ArrayList<String> getDictionary(String name) throws IOException {
        Path path = Paths.get(name);
        Scanner scanner = new Scanner(path);
        ArrayList<String> words = new ArrayList<>();
        while (scanner.hasNextLine()) {
            words.add(scanner.nextLine());
        }
        return words;
    }
}
