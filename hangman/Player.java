package hangman;

import java.util.Scanner;

public class Player {
    private SecretWord secretWord;
    private String wrong = "";
    private String correct = "";

    public void setSecretWord() {
        secretWord = new SecretWord();
        secretWord.getNewSecret();
    }

    public void play() {
        System.out.println(secretWord.getSecret(correct));
        Scanner scanner = new Scanner(System.in);
        System.out.print("Guess: ");
        String letter = scanner.next();
        if(secretWord.contains(letter)) {
            correct = correct + letter;
        }
        else {
            wrong = wrong + letter;
        }
    }

    public boolean isHanged() {
        if(wrong.length() == 6) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean found() {
        if(secretWord.found(correct)) {
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String[] args) {
        Player player = new Player();
        player.setSecretWord();
        while(!player.isHanged()) {
            player.play();
            if(player.found()) {
                System.out.println("FOUND");
                break;
            }
        }
        if(player.isHanged()) {
            System.out.println("HANGED");
        }

    }
}
