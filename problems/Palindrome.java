package problems;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        // Read a string from the user
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        // Set front to ZERO
        int front = 0;
        // Set back to length of string - 1
        int back = s.length() - 1;
        // Set palindrome flag to TRUE
        boolean isPalindrome = true;
        // Loop until front >= back
        while (front < back) {
            // if char at front is not equal to char at back
            if (s.charAt(front) != s.charAt(back)) {
                // not a palindrome, set flag to FALSE and stop
                isPalindrome = false;
                break;
            }
            // Increase front and decrease back
            front++;
            back--;
        }
        // If flag is still TRUE it is a palindrome
        if (isPalindrome) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
    }
}
