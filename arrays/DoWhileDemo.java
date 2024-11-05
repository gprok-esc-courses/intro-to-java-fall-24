package arrays;

/*
 * Menu for a school system
 */

import java.util.Scanner;

public class DoWhileDemo {
    public static void main(String[] args) {
        int selection;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("SCHOOL MENU");
            System.out.println("1. View Students");
            System.out.println("2. Add Student");
            System.out.println("3. Add Grade");
            System.out.println("0. EXIT");
            System.out.print("Select: ");
            selection = sc.nextInt();

            switch (selection) {
                case 1:
                    System.out.println("Looking at students");
                    break;
                case 2:
                    System.out.println("Adding a student");
                    break;
                case 3:
                    System.out.println("Adding a grade");
                    break;
                case 0:
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Invalid selection");
                    break;
            }
        } while(selection != 0);
    }
}
