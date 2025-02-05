package weektwoexercises;

public class Person implements Comparable<Person>{
    String name;
    double height;
    double weight;

    public Person(String name, double height, double weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    public double getBMI() {
        return (weight * 703.0) / (height * height);
    }

    public String toString() {
        java.text.DecimalFormat df = new java.text.DecimalFormat("#.##");
        return (name + ":  ht = " + height + "; wt = " + weight + "; bmi = " + df.format(getBMI()));
    }

    @Override
    public int compareTo(Person p) {
        return this.name.compareTo(p.name);
    }
}
