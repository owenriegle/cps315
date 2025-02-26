package hashexercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.KeyStore.Entry;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

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

        Map<String, Integer> sortedMap = countedWords.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
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
