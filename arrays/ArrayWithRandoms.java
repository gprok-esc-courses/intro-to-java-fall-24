package arrays;

/*
 * 1. Create an array of size n, where n is given by the user
 * 2. Fill the array with random values (1-100)
 * 3. Find several statistics, like total, average,
 *      min, max, etc.
 */

import java.util.Random;
import java.util.Scanner;

public class ArrayWithRandoms {
    public static void main(String[] args) {
        // Task 1
        Scanner scanner = new Scanner(System.in);
        System.out.print("Give array size: ");
        int n = scanner.nextInt();

        int [] arr = new int[n];

        // Task 2
        Random rnd = new Random();
        for(int i = 0; i < n; i++) {
            arr[i] = rnd.nextInt(100);
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // Task 3: total, average
        int total = 0;
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            total = total + arr[i];
            if (max < arr[i]) {
                max = arr[i];
            }
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        System.out.println("Total: " + total);
        System.out.println("Average: " + (total / n));
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
    }
}
