package introduction;

import java.util.Scanner;

public class UserInputReader {
    public static void main(String[] args) {
        System.out.println("Type your name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Type your age: ");
        int age = scanner.nextInt();
        System.out.println("Welcome " + name + "!");
        System.out.println("You are " + age + " y.o.");
    }
}
