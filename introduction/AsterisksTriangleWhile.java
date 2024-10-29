package introduction;

import java.util.Scanner;

public class AsterisksTriangleWhile {
    public static void main(String[] args) {
        System.out.print("Give a number N: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int line = 1;
        while(line <= n) {
            int counter = 0;
            while(counter < line) {
                System.out.print("* ");
                counter++;
            }
            System.out.println();
            line++;
        }
    }
}
