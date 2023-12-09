package util;

import java.math.BigDecimal;
import java.util.Scanner;

public class ScannerUtil {
    private static final Scanner scanner = new Scanner(System.in);

    // Private constructor to prevent instantiation
    private ScannerUtil() {
    }

    public static int readInt(String prompt) {
        System.out.print(prompt + " ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid integer.");
            scanner.next();
            System.out.print(prompt + " ");
        }
        return scanner.nextInt();
    }

    public static long readLong(String prompt) {
        System.out.print(prompt + " ");
        while (!scanner.hasNextLong()) {
            System.out.println("Invalid input. Please enter a valid long value.");
            scanner.next();
            System.out.print(prompt + " ");
        }
        return scanner.nextLong();
    }


    public static boolean readBoolean(String prompt) {
        System.out.print(prompt + " ");
        while (!scanner.hasNextBoolean()) {
            System.out.println("Invalid input. Please enter a valid boolean.");
            scanner.next();
            System.out.print(prompt + " ");
        }
        return scanner.nextBoolean();
    }

    public static BigDecimal readBigDecimal(String prompt) {
        System.out.print(prompt + " ");

        while (!scanner.hasNextBigDecimal()) {
            System.out.println("Invalid input. Please enter a valid BigDecimal.");
            scanner.next();
            System.out.print(prompt + " ");
        }
        return scanner.nextBigDecimal();
    }

    public static String readString(String prompt) {
        System.out.print(prompt + " ");
        return scanner.next();
    }

    public static void closeScanner() {
        scanner.close();
    }

}
