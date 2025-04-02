/*
 * takes an array and prints the items in reverse order
 */
public class Exercise2array {
    public static void main(String[] args) {
        int[] arr = { 5, 13, 4, 97 };

        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }
}
