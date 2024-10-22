package introduction;

import java.util.Scanner;

public class Asterisks {
    public static void main(String[] args) {
        // Ask user for a number n
        System.out.println("Give a number: ");
        // Read the number n
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        int counter = 0;
        // Repeat n times
        while(counter < value) {
            // print an asterisk
            System.out.print("*");
            counter++;
        }
    }
}
