package hangman;

import java.util.Random;

/**
 * Keeps a list of words and provides a random word whenever asked
 */
public class WordCollection {
    private String [] words = {"Mississippi", "Oriented", "Encapsulation",
            "Inheritance", "Polymorphism"};

    public String getRandomWord() {
        Random rnd = new Random();
        int r = rnd.nextInt(words.length);
        String word = words[r];
        return word;
    }

    public static void main(String[] args) {
        WordCollection w = new WordCollection();
        System.out.println(w.getRandomWord());
    }
}
