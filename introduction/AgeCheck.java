package introduction;

import java.util.Scanner;

public class AgeCheck {
    public static void main(String[] args) {
        System.out.println("Age? ");
        Scanner scanner = new Scanner(System.in);
        int age = scanner.nextInt();

        if(age < 18) {
            System.out.println("Young");
        }
        else if (age < 60) {
            System.out.println("Middle age");
        }
        else {
            System.out.println("Older");
        }
    }
}
