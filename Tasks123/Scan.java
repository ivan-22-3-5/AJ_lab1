package Tasks123;

import java.util.Scanner;

public class Scan {
    static Scanner in = new Scanner(System.in);

    public static double scanDouble() {
        double num;
        while (true) {
            if (in.hasNextDouble()) {
                num = in.nextDouble();
                return num;
            } else {
                System.out.println("Incorrect input. Try again");
                in.nextLine();
            }
        }
    }

    public static int scanInt() {
        int num;
        while (true) {
            if (in.hasNextInt()) {
                num = in.nextInt();
                return num;
            } else {
                System.out.println("Incorrect input. Try again");
                in.nextLine();
            }
        }
    }

    public static String scanStr() {
        String str1;
        str1 = in.nextLine();
        return str1;
    }
}