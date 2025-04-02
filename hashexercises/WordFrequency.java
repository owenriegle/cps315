/*
 * takes file as argument and counts number of occurences of words in the file
 */
package hashexercises;

import java.util.*;
import java.io.*;

public class WordFrequency {
    public static void main(String... args) throws Exception {
        // if args.length is not 1, the user didn’t provide a text file in the command
        // line when calling the program. Throw en Exception and exit
        Scanner file = new Scanner(new File(args[0]));
        // The hashmap will hold a String as key and an Integer as Value.
        // The String will be the word in the file, the Value will be the frequency
        // count
        HashMap<String, Integer> hmap = new HashMap<>();
        while (file.hasNextLine()) {
            String line = file.nextLine();
            String[] words = line.split(" ");

            for (String w : words) {
                // if the map has this word as key, add 1 to count
                if (hmap.containsKey(w)) {
                    Integer cnt = hmap.get(w);
                    hmap.replace(w, cnt + 1);
                } else {
                    hmap.put(w, 1);
                }
            }
        }
        // Display the words and frequencies
        for (String s : hmap.keySet()) {
            System.out.println(s + ", " + hmap.get(s));
        }
        // To display the words alphabetically ordered, you can put the whole HashMap
        // content into a
        // TreeMap, using TreeMaps’s putAll() method:
        TreeMap<String, Integer> tmap = new TreeMap<>();
        tmap.putAll(hmap);
        System.out.println(tmap);

        file.close();
    }
}