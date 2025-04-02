/*
 * takes names, their city. and state from csv file and prompts user to return all names in a given state or city
 */
package hashexercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NamesCityState {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner userInput = new Scanner(System.in);

        Scanner file = new Scanner(new File("vv3.txt"));

        HashMap<String, String> fileMap = new HashMap<>();

        /*
         * puts file lines into map
         */
        while (file.hasNextLine()) {
            if (file.nextLine().isBlank())
                break;
            else {
                String line = file.nextLine();
                String[] vals = line.split(",");

                String lastName = vals[0];
                String firstName = vals[1];
                String cityName = vals[2];
                String stateName = vals[3];

                fileMap.put((lastName + ", " + firstName), cityName + ", " + stateName);
            }
        }

        int choice;

        do {
            System.out.println("1. Print all names in a city.");
            System.out.println("2. Print all names in a state.");
            System.out.print("Enter the value that corresponds to your chosen option: ");

            choice = userInput.nextInt();

            switch (choice) {
                case 1:
                    /*
                     * prints names (key) that match city (value)
                     */
                    userInput.nextLine(); // discard /n character
                    System.out.print("Enter the name of a city: ");
                    String city = userInput.nextLine();

                    returnList(fileMap, city);

                    break;
                case 2:
                    /*
                     * prints names (key) that contain state (value)
                     */
                    userInput.nextLine(); // discard /n character
                    System.out.print("Enter the two-character acronym of a state: ");
                    String state = userInput.nextLine();

                    returnList(fileMap, state);

                    break;
                default:
                    System.out.println("Choice is invalid, please enter a valid option: ");
                    break;
            }
        } while ((choice != 1) && (choice != 2));

        userInput.close();
        file.close();
    }

    public static void returnList(HashMap<String, String> map, String search) {
        ArrayList<Map.Entry<String, String>> matches = new ArrayList<>();

        /*
         * adds entries from main map to arraylist if search matches key's value
         */
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue().contains(search.toUpperCase())) {
                matches.add(entry);
            }
        }

        /*
         * if search is invalid, returns nothing
         * else return sorted arraylist of names that match search
         */
        if (matches.isEmpty()) {
            System.out.println("Nothing found.");
        } else {
            matches.sort((e1, e2) -> (e1.getKey().compareTo(e2.getKey())));
            for (int i = 0; i < matches.size(); i++) {
                System.out.println(matches.get(i).getKey());
            }
        }
    }
}
