/*
 * uses a stack to convert decimal number into binary
 */
import java.util.Scanner;
import java.util.Stack;

public class Exercise1q {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input integer: ");
        int binaryConv = scanner.nextInt();

        while (binaryConv != 0) {
            stack.push(binaryConv % 2);
            binaryConv /= 2;
        }

        while (!stack.empty()) {
            System.out.print(stack.pop());
        }
        scanner.close();
    }
}
