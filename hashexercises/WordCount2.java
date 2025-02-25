package hashexercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class WordCount2 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("5-para-lorem.txt"));

        LinkedHashMap<String, Integer> countedWords = new LinkedHashMap<>();

        StringBuilder file = new StringBuilder();
        String line;

        while ((line = in.readLine()) != null) {
            file.append(" " + line.toLowerCase().replaceAll("[^a-zA-Z0-9\\s]", ""));
        }

        Scanner scanner = new Scanner(file.toString());

        while (scanner.hasNext()) {
            String str = scanner.next();
            int num = wordCount(file.toString(), str);
            countedWords.put(str, num);
        }

        System.out.println(countedWords);

        scanner.close();
        in.close();
    }

    public static int wordCount(String file, String word) {
        Scanner scanner = new Scanner(file);
        int num = 0;

        while (scanner.hasNext()) {
            String str = scanner.next();
            if (str.equals(word)) {
                num++;
            }
        }

        scanner.close();
        return num;
    }

    public static void sort(LinkedHashMap map) {
    }
}
