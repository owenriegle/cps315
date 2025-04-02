/*
 * creates Person objects using data from csv file, then prints sorted by Person's name and bmi
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

/*
 * Person object
 */
class Person implements Comparable<Person> {
    String name;
    double height;
    double weight;

    public Person(String name, double height, double weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    public double getBMI() {
        return (weight * 703.0) / (height * height);
    }

    public String toString() {
        java.text.DecimalFormat df = new java.text.DecimalFormat("#.##");
        return (name + ":  ht = " + height + "; wt = " + weight + "; bmi = " + df.format(getBMI()));
    }

    @Override
    public int compareTo(Person p) {
        return this.name.compareTo(p.name);
    }
}

/*
 * class to use Person objects
 */
public class Comparison {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("namesWithHeightWeight.csv"));
        scanner.useDelimiter(",|\n");
        scanner.nextLine();

        LinkedList<Person> people = new LinkedList<>();

        System.out.println(scanner.nextLine());

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] vals = line.split(",");
            String name = vals[1] + " " + vals[0];
            double height = Double.parseDouble(vals[2]);
            double weight = Double.parseDouble(vals[3]);
            Person person = new Person(name, height, weight);
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
