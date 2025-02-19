import java.util.concurrent.ThreadLocalRandom;

public class Exercise3array {
    public static void main(String[] args) {
        int[] arr = new int[100];
        int sum = 0;
        int mean = 0;
        int numAboveMean = 0;

        for (int i = 0; i < arr.length; i++) {
            int rand = ThreadLocalRandom.current().nextInt(10, 200);
            arr[i] = rand;
            sum += rand;
        }

        System.out.println("Generated 100 integers between 10 and 200.");

        mean = sum / arr.length;

        System.out.println("Mean = " + mean);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > mean) {
                numAboveMean++;
            }
        }

        System.out.println("# of elements above mean: " + numAboveMean);
    }
}
