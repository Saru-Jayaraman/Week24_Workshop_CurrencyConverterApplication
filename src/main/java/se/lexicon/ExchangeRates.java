package se.lexicon;

public class ExchangeRates {
    public static double convertSekToUsd(double inputAmount) {
        return inputAmount * 0.096;
    }

    public static double convertUsdToSek(double inputAmount) {
        return inputAmount * 10.37;
    }

    public static double convertSekToEuro(double inputAmount) {
        return inputAmount * 0.089;
    }

    public static double convertEuroToSek(double inputAmount) {
        return inputAmount * 11.21;
    }

    public static double convertUsdToEuro(double inputAmount) {
        return inputAmount * 0.93;
    }

    public static double convertEuroToUsd(double inputAmount) {
        return inputAmount * 1.08;
    }
}
