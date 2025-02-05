package weektwoexercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class USCounties {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("US_Counties.csv"));

        // scanner setup for csv
        scanner.useDelimiter(",|\n");
        scanner.nextLine();

        ArrayList<County> counties = new ArrayList<>();

        while (scanner.hasNext()) {
            counties.add(new County(scanner.next(), scanner.next(), scanner.next(), scanner.nextInt(), scanner.nextInt(), scanner.nextDouble(), scanner.nextDouble()));
        }

        scanner.close();
    }
}
