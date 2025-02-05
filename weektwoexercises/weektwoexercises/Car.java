package weektwoexercises;

public class Car implements Comparable<Car> {
    String model;
    String origin;
    int year;
    int cylinders;
    int horsepower;
    double mpg;
    int weight;

    public Car(String model, String origin, int year, int cylinders, int horsepower, double mpg, int weight) {
        this.model = model;
        this.origin = origin;
        this.year = year;
        this.cylinders = cylinders;
        this.horsepower = horsepower;
        this.mpg = mpg;
        this.weight = weight;
    }

    public String toString() {
        return ("Model name: " + model + ";  Origin: " + origin + "; Year: " + year + "; Cylinders: " + cylinders
                + "; Horsepower: " + horsepower + "; MPG: " + mpg + "; Weight: " + weight);
    }

    @Override
    public int compareTo(Car o) {
        return this.model.compareTo(o.model);
    }
}
