package se.lexicon;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        String userChoice;
        try {
            do {
                displayMenu();
                System.out.println("Enter the choice between 0 to 6:");
                userChoice = scanner.next();
                int userChoiceNumber = Integer.parseInt(userChoice);
                if(userChoiceNumber < 0 || userChoiceNumber > 6)
                    throw new MyException("USER HANDLED IllegalArgumentException MESSAGE: Enter a valid input choice... " +
                            "Input choice cannot be neither negative nor positive number above 6...");
                performOperation(userChoice);
            } while(Integer.parseInt(userChoice) != 0);
            System.out.println("Application Terminated...");
        } catch (NumberFormatException e) {
            System.out.println("============================================");
            System.out.println("PRE-DEFINED NumberFormatException MESSAGE: User choice/Currency amount cannot be a String...");
            System.out.println("============================================");
        } catch (MyException e) {
            System.out.println("============================================");
        } catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
    public static void displayMenu() {
        System.out.println("1. SEK to USD");
        System.out.println("2. USD to SEK");
        System.out.println("3. SEK to EURO");
        System.out.println("4. EURO to SEK");
        System.out.println("5. USD to EURO");
        System.out.println("6. EURO to USD");
        System.out.println("0. Exit");
    }
    public static void performOperation(String userChoice) throws MyException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        double inputAmount;
        switch (userChoice) {
            case "1":
                inputAmount = getInput();
                handleError(inputAmount, "convertSekToUsd", "SEK", "USD");
                break;
            case "2":
                inputAmount = getInput();
                handleError(inputAmount, "convertUsdToSek", "USD", "SEK");
                break;
            case "3":
                inputAmount = getInput();
                handleError(inputAmount, "convertSekToEuro", "SEK", "EURO");
                break;
            case "4":
                inputAmount = getInput();
                handleError(inputAmount, "convertEuroToSek", "EURO", "SEK");
                break;
            case "5":
                inputAmount = getInput();
                handleError(inputAmount, "convertUsdToEuro", "USD", "EURO");
                break;
            case "6":
                inputAmount = getInput();
                handleError(inputAmount, "convertEuroToUsd", "EURO", "USD");
                break;
            case "0":
                System.out.println("Exiting the program...");
                break;
        }
    }
    public static double getInput() {
        Scanner scanner = new Scanner(System.in);
        String inputNumberinString;
        double inputNumber;
        System.out.println("Enter the amount to convert:");
        inputNumberinString = scanner.next();
        inputNumber = Double.parseDouble(inputNumberinString);
        return inputNumber;
    }
    public static void displayOutputAmount(Double inputAmount, Double outputAmount,
                                           String inputCurrencyType, String outputCurrencyType) {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(inputAmount + " " + inputCurrencyType + " is converted to "
                            + outputAmount + " " + outputCurrencyType + " on the DATE & TIME:  " + dateTimeFormatter.format(localDateTime));
    }
    public static void handleError(double inputAmount, String functionName, String inputCurrencyType, String outputCurrencyType) throws MyException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (inputAmount < 0)
            throw new MyException("USER HANDLED IllegalArgumentException MESSAGE: Enter a valid input currency amount..." +
                    "Currency amount cannot be negative...");
        else {
            Class<ExchangeRates> exchangeRatesClass = ExchangeRates.class;
            Method method = exchangeRatesClass.getMethod(functionName, Double.class);
            Double outputAmount = (Double) method.invoke(null, inputAmount);

            Class<App> appClass = App.class;
            Method method1 = appClass.getMethod("displayOutputAmount", Double.class, Double.class, String.class, String.class);
            method1.invoke(null, inputAmount, outputAmount, inputCurrencyType, outputCurrencyType);
        }
    }
}