package arrays;

/*
 * 1. Fill an array with random values
 * 2. Print the array, then print backwards
 */

import java.util.Random;

public class MoreOnArrays {
    public static void main(String[] args) {
        int size = 20;
        int [] arr = new int[size];
        Random  rnd = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(100);
        }

        // Print
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // Print backwards
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // Print every 2 cells of the array
        // i = i + 2 is the same as i += 2
        for (int i = 0; i < arr.length; i += 2) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }
}
