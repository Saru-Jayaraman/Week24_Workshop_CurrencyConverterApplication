package se.lexicon;

import static se.lexicon.ValuesForExchangeRates.*;

public class ExchangeRates {
    public static double convertSekToUsd(Double inputAmount) {
        return inputAmount * valueSekToUsd;
    }

    public static double convertUsdToSek(Double inputAmount) {
        return inputAmount * valueUsdToSek;
    }

    public static double convertSekToEuro(Double inputAmount) {
        return inputAmount * valueSekToEuro;
    }

    public static double convertEuroToSek(Double inputAmount) {
        return inputAmount * valueEuroToSek;
    }

    public static double convertUsdToEuro(Double inputAmount) {
        return inputAmount * valueUsdToEuro;
    }

    public static double convertEuroToUsd(Double inputAmount) {
        return inputAmount * valueEuroToUsd;
    }
}
