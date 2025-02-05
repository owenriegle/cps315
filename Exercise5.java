package arraylistexercises;

public class Exercise5 {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 37, 4, 5 };
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max)  {
                max = arr[i];
            }
        }
        System.out.println("The max element in the array is " + max);
    }
}
