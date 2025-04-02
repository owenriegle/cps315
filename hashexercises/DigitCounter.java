/*
 * class that takes BigInteger factorial and counts occurences of digits 0-9
 */
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
                digits.put(num, 0);
            }
            else {
                digits.put(num, (digits.get(num) + 1));
            }
        }

        System.out.println("How many of each numeric digit (0, 1, ... 9) does 100! contain?");
        for (char c = '0'; c <= '9'; c++) {
            System.out.println("100! has " + digits.get(c) + " occurences of " + c);
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