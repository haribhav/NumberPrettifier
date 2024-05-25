package com.numberpretiffier;

import java.util.Scanner;

public class NumberPrettifier {
    public static String prettifyNumber(double number) {
        // absolute value of the number to determine its magnitude
        long absNumber = Math.abs((long) number);
        // If the number is less than a million, the same number is returned
        if (absNumber < 1_000_000) {
            return formatNumber(number);
        }
        int exponent = (int) (Math.log10(absNumber) / 3);  // Determines the group: million, billion, or trillion
        //System.out.println("exponent : "+exponent);
        if (exponent > 4) {
            exponent = 4;  // We stop at exponent 4 for now at trillions but it can be scaled in the future
        }
        double divisor = Math.pow(1000, exponent);
        // System.out.println("divisor : "+divisor);
        String suffix = getSuffix(exponent);
        return formatNumber(number / divisor) + suffix;
    }

    private static String getSuffix(int exponent) {
        switch (exponent) {
            //Thousands don't have a suffix that's why we begin the case with 2
            case 1:
                return "";
            case 2:
                return "M";
            case 3:
                return "B";
            case 4:
                return "T";
            default:
                return "T"; // Using 'T' here for all the exponent >= 4 (above trillions)
        }
    }

    private static String formatNumber(double number) {
        if (number == (long) number) {
            return String.format("%d", (long) number); // formatting to an integer
        } else {
            return String.format("%.1f", number); // formatting to 1 decimal places
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter numbers to prettify. Type 'exit' to quit.");
        while (true) {
            System.out.print("Enter a number: ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            try {
                // Parsing input as a double and prettify the number
                double number = Double.parseDouble(input);
                String prettified = prettifyNumber(number);
                System.out.println("Prettified: " + prettified);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please try again.");
            }
        }
        scanner.close();
        System.out.println("Program terminated.");
    }
}
