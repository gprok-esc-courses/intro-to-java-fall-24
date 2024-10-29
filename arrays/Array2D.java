package arrays;

import java.util.Random;

public class Array2D {
    public static void main(String[] args) {
        int [][] data = new int[3][3];
        Random rand = new Random();

        for(int row = 0; row < 3; row++) {
            for(int col = 0; col < 3; col++) {
                data[row][col] = rand.nextInt(100);
            }
        }

        for(int row = 0; row < 3; row++) {
            for(int col = 0; col < 3; col++) {
                System.out.print(data[row][col] + " ");
            }
            System.out.println();
        }
    }
}
