package hashexercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class NamesCityState {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner userInput = new Scanner(System.in);

        Scanner file = new Scanner(new File("vv3.txt"));

        HashMap<String, String> namesCity = new HashMap<>();

        while (file.hasNextLine()) {
            if (file.nextLine().isBlank()) break;
            else {
                String line = file.nextLine();
                String[] vals = line.split(",");

                System.out.println(line);

                String lastName = vals[0];
                String firstName = vals[1];
                String cityName = vals[2];
                String stateName = vals[3];

                namesCity.put((firstName + " " + lastName), cityName + ", " + stateName);
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
                    userInput.nextLine(); // discard /n character
                    System.out.print("Enter the name of a city: ");
                    String city = userInput.nextLine();

                    System.out.println(namesCity.keySet());
                    break;
                case 2:
                    System.out.println("Print names in state.");
                    break;
                default:
                    System.out.println("Choice is invalid, please enter a valid option: ");
                    break;
            }
        } while ((choice != 1) && (choice != 2));

        userInput.close();
        file.close();
    }
}
