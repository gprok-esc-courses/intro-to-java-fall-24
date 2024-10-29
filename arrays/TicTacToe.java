package arrays;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [][] board = new String[3][3];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = "-";
            }
        }
        String player = "X";

        boolean winner = false;
        boolean tie = false;

        // Start the game
        while(!winner && !tie) {
            // print the board
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[row].length; col++) {
                    System.out.print(board[row][col] + " ");
                }
                System.out.println();
            }
            // Ask user to play
            System.out.print("Give row: ");
            int r = sc.nextInt();
            System.out.print("Give column: ");
            int c = sc.nextInt();
            // Check valid r and c values (o, 1, or 2)
            if(r < 0 || r > 2 || c < 0 || c > 2) {
                System.out.println("Value out of range 0 - 2");
                continue;
            }
            // if pos is empty, update board, else skip the rest
            if(board[r][c].equals("-")) {
                board[r][c] = player;
            }
            else {
                System.out.println("Position already occupied");
                continue;
            }
            // check for winner
            // Check rows
            for (int row = 0; row < 3; row++) {
                if(board[row][0].equals(board[row][1]) && board[row][0].equals(board[row][2]) && !board[row][0].equals("-")) {
                    System.out.println(board[row][0] + " WINS!");
                    winner = true;
                }
            }
            // Check columns
            for (int col = 0; col < 3; col++) {
                if(board[0][col].equals(board[1][col]) && board[0][col].equals(board[2][col]) && !board[0][col].equals("-")) {
                    System.out.println(board[0][col] + " WINS!");
                    winner = true;
                }
            }
            // Check diagonals
            if(board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2]) && !board[0][0].equals("-")) {
                System.out.println(board[0][0] + " WINS!");
                winner = true;
            }
            if(board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0]) && !board[0][2].equals("-")) {
                System.out.println(board[0][2] + " WINS!");
                winner = true;
            }
            // check for tie
            if(!winner) {
                tie = true;
                for (int row = 0; row < board.length; row++) {
                    for (int col = 0; col < board[row].length; col++) {
                        if(board[row][col].equals("-")) {
                            tie = false;
                        }
                    }
                }
                if(tie) {
                    System.out.println("It's a TIE!");
                }
            }
            // change player
            if(player.equals("X")) {
                player = "O";
            }
            else {
                player = "X";
            }
        }
        // print the board
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }
}
