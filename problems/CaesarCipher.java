package problems;

import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        String letters = "abcdefghijklmnopqrstuvwxyz";
        Scanner in = new Scanner(System.in);
        // Read a sentence from the user
        System.out.print("Give a sentence: ");
        String sentence = in.nextLine();
        // Convert to lower case
        sentence = sentence.toLowerCase();
        System.out.println(sentence);
        // Read the key from the user
        System.out.print("Give the key (1-25): ");
        int key = in.nextInt();
        // Initialize a secret as an empty string
        String secret = "";
        // For each character in the sentence
        for (int i = 0; i < sentence.length(); i++) {
            // Find the encrypted character (key letters next)
            char c = sentence.charAt(i);
            if(c == ' ') {
                secret += c;
            }
            else {
                int index = letters.indexOf(c);
                int pos = index + key;
                if (pos >= letters.length()) {
                    pos = pos - letters.length();
                }
                // Add the encrypted character to the secret
                char e = letters.charAt(pos);
                secret += e;
            }
        }
        // Print the secret
        System.out.println(secret);
    }
}
