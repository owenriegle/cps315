/*
 * creates a size 10 array and generates a random number between 5 and 25 per index
 */
import java.util.concurrent.ThreadLocalRandom;

public class Exercise1array {
    public static void main(String[] args) {
        int[] n = new int[10];

        int a = 5;
        int b = 25;

        for (int i = 0; i < 10; i++) {
            n[i] = ThreadLocalRandom.current().nextInt(a, b);
            System.out.print(n[i] + " ");
        }

    }
}
