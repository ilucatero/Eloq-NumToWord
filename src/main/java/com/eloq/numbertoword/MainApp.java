package com.eloq.numbertoword;


import java.util.Locale;
import java.util.Scanner;

/**
 * An application that converts numbers into words
 */
public class MainApp {

    public static void main(String... args) {
        Float number;
        boolean isTryAgain = true;

        try(Scanner scanner = new Scanner(System.in)) {
            do {
                System.out.print("Write a number to convert (max value upto " + Integer.MAX_VALUE + "): ");
                try {
                    // set locale as US to always use dot instead comma (case of locale.FR)
                    scanner.useLocale(Locale.US);

                    // read the number
                    number = scanner.nextFloat();
                    System.out.println(NumberToWordsConverterEN.convert(number.intValue()));

                    scanner.nextLine(); // to consume the prev \n on nextLong
                } catch (Exception e) {
                    System.out.println("The typed value is not valid! \n Please try again." + e);
                    scanner.nextLine(); // to consume the prev \n on nextLong
                    continue;
                }


                System.out.print("Would you like to try another number? [y] : ");
                try {
                    String userInput = scanner.nextLine();
                    isTryAgain = userInput.trim().isEmpty() || "y".equals(userInput.toLowerCase());
                } catch (Exception e) {
                    System.out.print(e);
                }
            } while (isTryAgain);

        } // close the reader

    }

}

