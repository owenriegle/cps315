/*
 * returns sum of all numbers entered by user by method
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Exercise10 {
    public static void main(String[] args) {
        ArrayList<Integer> ar = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.println("Enter a number:");
            ar.add(scanner.nextInt());
        }
        System.out.println(ar);
        System.out.println(sum(ar));
        scanner.close();
    }

    public static int sum(ArrayList<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }
}
