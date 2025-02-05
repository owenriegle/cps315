package arraylistexercises;

import java.util.concurrent.ThreadLocalRandom;

public class Exercise4 {
    public static void main(String[] args) {
        int[] arr = new int[10];

        System.out.println("Generating 100 random integers between 0 and 9.");

        for (int i = 0; i <= 100; i++) {
            int rand = ThreadLocalRandom.current().nextInt(10);
            switch (rand) {
                case 0:
                    arr[0]++;
                    break;
                case 1:
                    arr[1]++;
                    break;
                case 2:
                    arr[2]++;
                    break;
                case 3:
                    arr[3]++;
                    break;
                case 4:
                    arr[4]++;
                    break;
                case 5:
                    arr[5]++;
                    break;
                case 6:
                    arr[6]++;
                    break;
                case 7:
                    arr[7]++;
                    break;
                case 8:
                    arr[8]++;
                    break;
                case 9:
                    arr[9]++;
                    break;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println("Count for " + i + " is " + arr[i]);
        }
    }
}
