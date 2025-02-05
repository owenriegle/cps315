package weektwoexercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class County implements Comparable<County> {
    String state;
    String countyName;
    String region;
    String metro;
    int population;
    int incomePerCapita;
    double unemploymentRate;
    double landArea;

    public County(String state, String countyName, String region, String metro, int population, int incomePerCapita,
            double unemploymentRate, double landArea) {
        this.state = state;
        this.countyName = countyName;
        this.region = region;
        this.metro = metro;
        this.population = population;
        this.incomePerCapita = incomePerCapita;
        this.unemploymentRate = unemploymentRate;
        this.landArea = landArea;
    }

    public String toString() {
        return ("County: " + countyName + "; Region: " + region + "; Metro: " + metro
                + "; Population: " + population + "; Income per capita: " + incomePerCapita + "; Unemployment rate: "
                + unemploymentRate + "; Land area: " + landArea + "; Population Density per square mile: " + this.getPopDensity());
    }

    public int getPopDensity() {
        return (int) (this.population / this.landArea);
    }

    @Override
    public int compareTo(County c) {
        return this.countyName.compareTo(c.countyName);
    }
}

public class USCounties {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner csv = new Scanner(new File("US_Counties.csv"));
        Scanner userInput = new Scanner(System.in);

        ArrayList<County> counties = new ArrayList<>();

        // scanner setup for csv
        csv.useDelimiter(",|\n");
        csv.nextLine();

        // adds county info from csv to arraylist
        while (csv.hasNextLine()) {
            String line = csv.nextLine();
            String[] vals = line.split(",");
            String state = vals[0];
            String countyName = vals[1];
            String region = vals[2];
            String metro = vals[3];
            int population = Integer.parseInt(vals[4]);
            int incomePerCapita = Integer.parseInt(vals[5]);
            double unemploymentRate = Double.parseDouble(vals[6]);
            double landArea = Double.parseDouble(vals[7]);
            counties.add(new County(state, countyName, region, metro, population, incomePerCapita, unemploymentRate,
                    landArea));
        }
        csv.close();

        // prompts user for state name
        System.out.print("Enter the name of a U.S. State to see it's counties info: ");
        String stateName = userInput.nextLine();
        ArrayList<County> stateCounties = new ArrayList<>();
        
        // adds county to stateName arraylist if the county's state matches user inputted state
        for (County c : counties) {
            if (c.state.equalsIgnoreCase(stateName)) {
                stateCounties.add(c);
            }
        }

        // sorts and prints stateName arraylist alphabetically by county name
        System.out.println("\n---Sorting Alphabetically by County Name for " + stateCounties.getFirst().state);
        stateCounties.sort(null);
        for (County c : stateCounties) {
            System.out.println(c);
        }

        // sorts and prints stateName arraylist in order of descending unemployment rate
        System.out.println("\n---Sorting Descending by County's Unemployment Rate for " + stateCounties.getFirst().state);
        stateCounties.sort(null);
        stateCounties.sort((c1, c2) -> (int) (Math.signum(c2.unemploymentRate - c1.unemploymentRate)));
        for (County c : stateCounties) {
            System.out.println(c);
        }

        // sorts and prints stateName arraylist in order of ascending population density
        System.out.println("\n---Sorting Ascending by County's Population Rate for " + stateCounties.getFirst().state);
        stateCounties.sort(null);
        stateCounties.sort((c1, c2) -> (int) (Math.signum(c1.getPopDensity() - c2.getPopDensity())));
        for (County c : stateCounties) {
            System.out.println(c);
        }

        userInput.close();
    }
}
