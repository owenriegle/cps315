package weektwoexercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Comparison {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("namesWithHeightWeight.csv"));
        scanner.useDelimiter(",|\n");
        scanner.nextLine();

        LinkedList<Person> people = new LinkedList<>();

        while (scanner.hasNext()) {
            String lastName = scanner.next().strip();
            String firstName = scanner.next().strip();
            Person person = new Person((firstName + " " + lastName), scanner.nextDouble(), scanner.nextDouble());
            people.add(person);
        }

        System.out.println("\n---Sorting by Name");
        people.sort(null);
        // Print the linked list using an enhanced for-loop
        for (Person p : people) {
            System.out.println(p);
        }

        System.out.println("\n---Sorting by BMI");
        people.sort((p1, p2) -> (int) (Math.signum(p1.getBMI() - p2.getBMI())));
        for (Person p : people) {
            System.out.println(p);
        }

        scanner.close();
    }
}
