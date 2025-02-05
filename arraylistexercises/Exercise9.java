package arraylistexercises;

import java.util.ArrayList;
import java.util.Collections;

public class Exercise9 {
    public static void main(String[] args) {
        ArrayList<Integer> ar = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            ar.add(i * 10);
        }
        System.out.println(ar);
        System.out.println(shuffle(ar));
    }

    public static ArrayList<Integer> shuffle(ArrayList<Integer> list) {
        Collections.shuffle(list);
        return list;
    }
}
