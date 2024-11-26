package files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AccountsReader {
    public static void main(String[] args) {
        try {
            File accountsFile = new File("accounts.txt");
            Scanner scanner = new Scanner(accountsFile);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String [] tokens = line.split(",");
                System.out.println(tokens[2]);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
