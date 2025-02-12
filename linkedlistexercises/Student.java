

public class Student {
    int id;
    String name;
    String dob;
    int major;
    int score;

    public Student(int id, String name, String dob, int major, int score) {
        this.name = name;
        this.id = id;
        this.dob = dob;
        this.major = major;
        this.score = score;
    }

    public String toString() {
        return "Name = " + name + "; id = " + id + "; major = " + major + "; score = " + score;
    }
}
