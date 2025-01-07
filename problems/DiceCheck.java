package problems;

import java.util.Random;

/**
 * Roll a die 1.000 times,
 * and record the values.
 * Print how many times each value 1-6 appeared.
 */
public class DiceCheck {
    public static void main(String[] args) {
        int [] values = {0, 0, 0, 0, 0, 0};

        Random random = new Random();

        for (int i = 0; i < 1000; i++) {
            int v = random.nextInt(6);
            values[v]++;
        }

        for (int i = 0; i < 6; i++) {
            System.out.println((i+1) + ": " + values[i]);
        }
    }
}
