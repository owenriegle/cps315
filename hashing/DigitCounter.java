package hashing;

import java.math.BigInteger;
import java.util.HashMap;

public class DigitCounter {
    public static void main(String[] args) {
        long hundred = 10;
        String factorial = factorial(BigInteger.valueOf(hundred)).toString();
        HashMap digits = new HashMap<>();

        for (int i = 0; i < factorial.length(); i++) {
            char num = factorial.charAt(i);
            digits.putIfAbsent(num, 1);
        }
        
        System.out.println("How many of each numeric digit (0, 1, ... 9) does 100! contain?");
        for (int i = 0; i < 10; i++) {
            char look = Character.getNumericValue(0);
            System.out.println("100! has " + digits.get(i) + " occurences of " + i);
        }
    }

    public static BigInteger factorial(BigInteger x) {
        long one = 1;
        if (x.equals(BigInteger.valueOf(one)))
            return BigInteger.valueOf(one);
        else
            return x.multiply(factorial(x.subtract(BigInteger.valueOf(one))));
    }
}