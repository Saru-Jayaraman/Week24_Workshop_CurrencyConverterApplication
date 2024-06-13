package se.lexicon;

import java.util.Scanner;

import static se.lexicon.ExchangeRates.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        displayMenu();
        System.out.println("Enter the choice between 1 to 7:");
        int userChoice = scanner.nextInt();
        performOperation(userChoice);
    }
    public static void displayMenu() {
        System.out.println("1. SEK to USD");
        System.out.println("2. USD to SEK");
        System.out.println("3. SEK to EURO");
        System.out.println("4. EURO to SEK");
        System.out.println("5. USD to EURO");
        System.out.println("6. EURO to USD");
        System.out.println("7. Exit");
    }
    public static void performOperation(int userChoice) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the amount to convert:");
        double inputAmount = scanner.nextDouble();
        double outputAmount;
        switch (userChoice) {
            case 1:
                outputAmount = convertSekToUsd(inputAmount);
                displayOutputAmount(inputAmount, outputAmount, "SEK", "USD");
                break;
            case 2:
                outputAmount = convertUsdToSek(inputAmount);
                displayOutputAmount(inputAmount, outputAmount, "USD", "SEK");
                break;
            case 3:
                outputAmount = convertSekToEuro(inputAmount);
                displayOutputAmount(inputAmount, outputAmount, "SEK", "EURO");
                break;
            case 4:
                outputAmount = convertEuroToSek(inputAmount);
                displayOutputAmount(inputAmount, outputAmount, "EURO", "SEK");
                break;
            case 5:
                outputAmount = convertUsdToEuro(inputAmount);
                displayOutputAmount(inputAmount, outputAmount, "USD", "EURO");
                break;
            case 6:
                outputAmount = convertEuroToUsd(inputAmount);
                displayOutputAmount(inputAmount, outputAmount, "EURO", "USD");
                break;
            case 7:
                System.out.println("Exiting the program...");
                break;
            default:
                System.out.println("Invalid choice...");
                break;
        }
    }
    public static void displayOutputAmount(double inputAmount, double outputAmount,
                                           String inputCurrencyType, String outputCurrencyType) {
        System.out.println(inputAmount + inputCurrencyType + " is converted to "
                                                    + outputAmount + outputCurrencyType);
    }
}
