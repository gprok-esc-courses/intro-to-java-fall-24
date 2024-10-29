package arrays;

import java.util.Scanner;

public class SimpleArray {
    public static void main(String[] args) {
        int [] grades = new int[5];
        String [] names = new String[5];

        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < grades.length; i++) {
            System.out.print("Give name: ");
            names[i] = sc.nextLine();
            System.out.print("Give grade " + i + ": ");
            grades[i] = sc.nextInt();
            sc.nextLine();   // empty enter from the buffer
        }

        for(int i = 0; i < grades.length; i++) {
            System.out.println(names[i] + ": " + grades[i] + " ");
        }
        System.out.println();
    }
}
