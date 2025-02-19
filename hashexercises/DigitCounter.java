package hashexercises;

import java.math.BigInteger;
import java.util.HashMap;

public class DigitCounter {
    public static void main(String[] args) {
        long hundred = 100;
        String factorialString = factorial(BigInteger.valueOf(hundred)).toString();
        HashMap<Character, Integer> digits = new HashMap<>();

        for (int i = 0; i < factorialString.length(); i++) {
            char num = factorialString.charAt(i);
            if (!digits.containsKey(num)) {
                
                digits.put(num, 1);
            } else {
                digits.replace(num, (Character.getNumericValue(digits.get(num)) + 1));
            }
        }
        
        System.out.println(digits);

        System.out.println("How many of each numeric digit (0, 1, ... 9) does 100! contain?");
        for (int i = 0; i < 10; i++) {
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