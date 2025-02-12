

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner arScanner = new Scanner(new File("exam_scores.csv"));
        Scanner llScanner = new Scanner(new File("exam_scores.csv"));
        // sets delimters
        arScanner.useDelimiter(",|\n");
        llScanner.useDelimiter(",|\n");
        // gets rid of column line
        arScanner.nextLine();
        llScanner.nextLine();

        // ArrayList implementation
        ArrayList<Student> studentAR = new ArrayList<>();

        while (arScanner.hasNext()) {
            Student student = new Student(arScanner.nextInt(), arScanner.next().strip(), arScanner.next().strip(),
                    arScanner.nextInt(), arScanner.nextInt());
            studentAR.add(student);
        }

        for (int i = 0; i < studentAR.size(); i++) {

            System.out.println(studentAR.get(i));
        }

        arScanner.close();

        // LinkedList implementation
        LinkedList<Student> studentLL = new LinkedList<>();

        while (llScanner.hasNext()) {
            int id = llScanner.nextInt();
            String name = llScanner.next().strip();
            String dob = llScanner.next().strip();
            // used to skip over major code
            llScanner.nextInt();
            int score = llScanner.nextInt();
            Student student = new Student(id, name, dob, 7, score);
            Node<Student> node = new Node<>(student);
            studentLL.add(node);
        }

        studentLL.printList();

        llScanner.close();
    }
}
