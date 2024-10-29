package introduction;

import java.util.Scanner;
public class AsterisksTriangleFor {
    public static void main(String[] args) {
        System.out.print("Give a number N: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int line = 1; line <= n; line++) {
            for(int counter = 0; counter < line; counter++) {
                System.out.print("* ");
            }
            System.out.println();

        }
    }
}
