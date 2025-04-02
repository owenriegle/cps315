/*
 * class that takes input from user and returns BigInteger factorial
 */
package hashexercises;

import java.math.BigInteger;
import java.util.Scanner;

public class BigIntegerFactorial {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number to compute as a factorial: ");
        BigInteger num = new BigInteger(input.next());

        System.out.print(num + "! = " + factorial(num));
        input.close();
    }

    public static BigInteger factorial(BigInteger x) {
        long one = 1;
        if (x.equals(BigInteger.valueOf(one)))
            return BigInteger.valueOf(one);
        else
            return x.multiply(factorial(x.subtract(BigInteger.valueOf(one))));
    }
}
