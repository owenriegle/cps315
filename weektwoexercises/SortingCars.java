package weektwoexercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class SortingCars {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("cars_data.csv"));
        scanner.useDelimiter(",|\n");
        scanner.nextLine();

        LinkedList<Car> cars = new LinkedList<>();

        while (scanner.hasNext()) {
            System.out.println(scanner.nextLine());
            cars.add(new Car(scanner.next(), scanner.next(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt(),
                    scanner.nextDouble(), scanner.nextInt()));
        }

        System.out.println("\n---Printing list of cars");
        for (Car c : cars) {
            System.out.println(c);
        }

        System.out.println("\n---Sorting by Name");
        cars.sort(null);
        for (Car c : cars) {
            System.out.println(c);
        }

        System.out.println("\n---Sorting by Year");
        cars.sort((c1, c2) -> (int) (Math.signum(c1.year - c2.year)));
        for (Car c : cars) {
            System.out.println(c);
        }

        System.out.println("\n---Sorting by Horsepower");
        cars.sort((c1, c2) -> (int) (Math.signum(c1.horsepower - c2.horsepower)));
        for (Car c : cars) {
            System.out.println(c);
        }

        System.out.println("\n---Sorting by Weight");
        cars.sort((c1, c2) -> (int) (Math.signum(c1.weight - c2.weight)));
        for (Car c : cars) {
            System.out.println(c);
        }

        scanner.close();
    }
}
