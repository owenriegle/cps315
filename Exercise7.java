package arraylistexercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercise7 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("in.txt"));
        ArrayList<Integer> ar = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int max = 0;

        while (scanner.hasNextInt()) {
            int nextInt = scanner.nextInt();
            ar.add(nextInt);
            if (nextInt > max) {
                max = nextInt;
                min = nextInt;
            }
            if (nextInt < min) {
                min = nextInt;
            }
        }

        System.out.println(ar.size() + " " + min + " " + max);
        scanner.close();
    }
}
