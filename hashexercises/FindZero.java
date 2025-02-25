package hashexercises;

import java.util.HashSet;

public class FindZero {
    public static void main(String[] args) {
        Integer[] array = { -5, -4, -3, -2, -1, 0, 3 };
        findPairs(array);
    }

    public static void findPairs(Integer[] list) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : list) {
            if (set.contains(-num)) {
                System.out.println("x + y = 0 found: " + num + " and " + -num);
            }
            set.add(num);
        }
    }
}
