package by.pvt.kish.util;

import java.util.Scanner;

/**
 * @author Kish Alexey
 */
public class ScannerUtil {

    public static String readTitle(Scanner scanner) {
        System.out.println("Enter title:");
        return scanner.nextLine();
    }

    public static int readId(Scanner scanner) {
        System.out.println("Enter ID:");
        return Integer.parseInt(scanner.nextLine());
    }

    public static String readName(Scanner scanner) {
        System.out.println("Enter name:");
        return scanner.nextLine();
    }

    public static String readOwner(Scanner scanner) {
        System.out.println("Enter owner:");
        return scanner.nextLine();
    }

    public static String readSurname(Scanner scanner) {
        System.out.println("Enter surname:");
        return scanner.nextLine();
    }

    public static int readAge(Scanner scanner) {
        System.out.println("Enter age:");
        return Integer.parseInt(scanner.nextLine());
    }
}
