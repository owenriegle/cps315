

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Exercise12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> answers = new ArrayList<>();
        boolean tryAgain = true;

        do {
            int rand1 = ThreadLocalRandom.current().nextInt(11);
            int rand2 = ThreadLocalRandom.current().nextInt(11);
            String response = "y";

            System.out.println("What is " + rand1 + " + " + rand2 + "?");
            int answer = scanner.nextInt();

            if (answer == (rand1 + rand2)) {
                answers.add(rand1 + "+" + rand2 + "=" + (rand1 + rand2));

                System.out.println("You got it!");
                System.out.println("Want to try another? (y/n) : ");
                response = scanner.next();

                while (!(response.equals("y") || response.equals("n"))) {
                    System.out.println("Please respond with y or n");
                    response = scanner.next();
                }
                if (response.equals("n")) {
                    tryAgain = false;
                }
            } else {
                while (answer != (rand1 + rand2)) {
                    System.out.println("Wrong. Try Again. What is " + rand1 + " + " + rand2 + "?");
                }
            }
        } while (tryAgain);

        System.out.println("Your correct answers were:");
        for (int i = 0; i < answers.size(); i++) {
            System.out.println(answers.get(i));
        }
        scanner.close();
    }
}
