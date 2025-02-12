

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise11 {
    public static void main(String[] args) {
        ArrayList<Integer> ar = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter ten integers:");
        for (int i = 0; i < 10; i++) {
            if (scanner.hasNextInt()) {
                ar.add(scanner.nextInt());
            } else {
                scanner.next();
            }
        }

        System.out.println(ar);
        System.out.println(removeDuplicates(ar));
        scanner.close();
    }

    public static ArrayList<Integer> removeDuplicates(ArrayList<Integer> list) {
        ArrayList<Integer> noDups = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            if (!noDups.contains(num)) {
                noDups.add(num);
            }
        }
        return noDups;
    }
}
