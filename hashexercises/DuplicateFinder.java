package hashexercises;

import java.util.HashMap;

public class DuplicateFinder {
    public static void main(String[] args) {
        Integer[] n = {1, 2, 3, 3, 4, 5};
        HashMap<Integer, Integer> dupFinder = new HashMap<>();

        for (int i = 0; i < n.length; i++) {
            if (dupFinder.containsKey(n[i])) {
                dupFinder.put(n[i], dupFinder.get(n[i]) + 1);
                System.out.println("Array contains a duplicate of " + n[i]);
                // breaks for efficiency since all we are looking for is the single expected dupe
                break;
            } else {
                dupFinder.put(n[i], 1);
            }
        }
    }
}
