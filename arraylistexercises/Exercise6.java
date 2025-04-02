/*
 * returns maximum integer in an array and its index by a method
 */
import java.util.Arrays;

public class Exercise6 {
    public static void main(String[] args) {
        int[] arr = { 12, 3, 4, 5, 11, 12, 43, 23, 89, 45, 14 };
        System.out.println(Arrays.toString(maxElement(arr)));
    }

    public static int[] maxElement(int[] a) {
        int[] maxElement = { 0, 0 };

        for (int i = 0; i < a.length; i++) {
            if (a[i] > maxElement[1]) {
                maxElement[0] = i;
                maxElement[1] = a[i];
            }
        }
        return maxElement;
    }
}
