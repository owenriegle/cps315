package hashexercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class NamesCityState {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner userInput = new Scanner(System.in);

        Scanner file = new Scanner(new File("vv3.txt"));
        file.useDelimiter(",|\n");

        int choice;

        do {
            System.out.println("1. Print all names in a city.");
            System.out.println("2. Print all names in a state.");
            System.out.print("Enter the value that corresponds to your chosen option: ");

            choice = userInput.nextInt();

            switch (choice) {
                case 1:
                    HashMap<String, String> namesCity = new HashMap<>();

                    System.out.println("Print names in city.");

                    while (file.hasNextLine()) {

                        String line = file.nextLine();
                        String[] vals = line.split(",");

                        if (file.nextLine().isEmpty()) {
                            break;
                        } else {
                            String lastName = vals[0];
                            String firstName = vals[1];
                            String city = vals[2];

                            namesCity.put((lastName + "," + firstName), city);
                        }
                    }

                    System.out.println(namesCity);

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
