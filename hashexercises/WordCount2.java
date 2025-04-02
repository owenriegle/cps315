/*
 * takes words from csv and returns number of occurences for all words sorted descending by occurences
 */
package hashexercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCount2 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("5-para-lorem.txt"));

        HashMap<String, Integer> countedWords = new HashMap<>();

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

        ArrayList<Map.Entry<String, Integer>> sortedMap = new ArrayList<>(countedWords.entrySet());

        sortedMap.sort((e1, e2) -> (e2.getValue().compareTo(e1.getValue())));

        for (Map.Entry<String, Integer> entry : sortedMap) {
            System.out.print(entry.getKey() + "=" + entry.getValue() + ", ");
        }

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
}
