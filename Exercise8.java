package arraylistexercises;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> ar = new ArrayList<>();
        String response = "y";
        int max = 0;

        do {
            System.out.println("Enter a number.");
            int num = scanner.nextInt();
            ar.add(num);
            if (num > max) {
                max = num;
            }
            System.out.println("Would you like to enter another number? y/n");
            response = scanner.next();
        } while (response.equals("y"));
        System.out.println(ar + " " + max);
        scanner.close();
    }
}
