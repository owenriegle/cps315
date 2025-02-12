

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

class Car implements Comparable<Car> {
    String model;
    String origin;
    int year;
    int cylinders;
    int horsepower;
    double mpg;
    int weight;

    public Car(String model, String origin, int year, int cylinders, int horsepower, double mpg, int weight) {
        this.model = model;
        this.origin = origin;
        this.year = year;
        this.cylinders = cylinders;
        this.horsepower = horsepower;
        this.mpg = mpg;
        this.weight = weight;
    }

    public String toString() {
        return ("Model name: " + model + ";  Origin: " + origin + "; Year: " + year + "; Cylinders: " + cylinders
                + "; Horsepower: " + horsepower + "; MPG: " + mpg + "; Weight: " + weight);
    }

    @Override
    public int compareTo(Car o) {
        return this.model.compareTo(o.model);
    }
}

public class SortingCars {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("cars_data.csv"));
        scanner.useDelimiter(",|\n");
        scanner.nextLine();

        LinkedList<Car> cars = new LinkedList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] vals = line.split(",");
            String model = vals[0];
            String origin = vals[1];
            int year = Integer.parseInt(vals[2]);
            int cylinders = Integer.parseInt(vals[3]);
            int horsepower = Integer.parseInt(vals[4]);
            double mpg = Double.parseDouble(vals[5]);
            int weight = Integer.parseInt(vals[6]);
            cars.add(new Car(model, origin, year, cylinders, horsepower, mpg, weight));
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
