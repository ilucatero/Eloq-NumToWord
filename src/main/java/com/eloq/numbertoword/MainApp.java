package com.eloq.numbertoword;


import java.util.Scanner;

/**
 * An application that converts numbers into words
 */
public class MainApp {

    public static void main(String... args) throws Exception {
        int number;
        boolean isTryAgain = true;

        try(Scanner scanner = new Scanner(System.in)) {
            do {
                System.out.print("Write a number to convert (max value upto " + Long.MAX_VALUE + "): ");
                try {
                    // read the number
                    number = scanner.nextInt();
                    if (number == 0) {
                        System.out.println("Zero");
                    } else {
                        // TODO : convert number to word
                        System.out.println(number);
                    }

                    scanner.nextLine(); // to consume the prev \n on nextLong
                } catch (Exception e) {
                    System.out.println("The typed value is not valid! \n Please try again.");
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

