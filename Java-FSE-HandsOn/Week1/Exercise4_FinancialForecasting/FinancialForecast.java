class FinancialForecast {

    public static double calculateFutureValue(double presentValue, double growthRate, int years) {

        // Base case
        if (years == 0) {
            return presentValue;
        }

        // Recursive case
        return calculateFutureValue(presentValue, growthRate, years - 1) * (1 + growthRate);
    }

    public static void main(String[] args) {

        double presentValue = 1000;
        double growthRate = 0.10;
        int years = 3;

        double futureValue = calculateFutureValue(presentValue, growthRate, years);

        System.out.println("Future Value after " + years + " years: " + futureValue);
    }
}