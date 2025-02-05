package weektwoexercises;

public class County {
    String state;
    String countyName;
    String region;
    int population;
    int incomePerCapita;
    double unemploymentRate;
    double landArea;

    public County(String state, String countyName, String region, int population, int incomePerCapita,
            double unemploymentRate, double landArea) {
        this.state = state;
        this.countyName = countyName;
        this.region = region;
        this.population = population;
        this.incomePerCapita = incomePerCapita;
        this.unemploymentRate = unemploymentRate;
        this.landArea = landArea;
    }
}
