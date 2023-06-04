package simplebankingsystem.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CommonUtils {
    public static Scanner scanner = new Scanner(System.in);
    
    public static String formatValue(double value) {
        return String.format("%.2f", value).replace(",", ".");
    }

    public static String replaceCommasWithDots(String input) {
        return input.replace(",", ".");
    }

    public static int getIntInput() {
        int input;
        while (true) {
            try {
                input = scanner.nextInt();
                scanner.nextLine(); // Cleaning the buffer: consuming the newline character (\n) left by pressing Enter
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid integer.");
                scanner.nextLine();
            }
        }
        return input;
    }
            
    public static String getLineInput() {
        String input;
        while (true) {
            try {
                input = scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid string.");
//                scanner.nextLine();
            }
        }
        return input;
    }
    
    public static double getDoubleInput() {
        while (true) {
            try {
                String input = scanner.nextLine();
                input = replaceCommasWithDots(input);
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }
    }

    public static String getValidName() {
        String input;
        while (true) {
        	input = getLineInput();
            if (input.matches("[A-Za-zÀ-ÿ ]+")) { //Accept spaces, letters from any alphabets, in upper case and lower case
                break;
            } else {
                System.out.println("Invalid input! Please enter a valid name (letters only).");
                scanner.nextLine();
            }
        }
        return input;
    }
    public static String getValidCpf() {
        String input;
        while (true) {
        	input = getLineInput();
            if (input.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) { //CPF format
                break;
            } else {
                System.out.println("Invalid input! Please enter a valid CPF (format: XXX.XXX.XXX-XX).");
            }
        }
        return input;
    }
}