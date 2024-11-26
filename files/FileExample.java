package files;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileExample {
    public static void main(String[] args) {
        try {
            File file = new File("data.txt");
            if (file.createNewFile()) {
                System.out.println("File created");
            }
            else {
                System.out.println("File already exists");
            }
            // Write to the file
            System.out.println("WRITING FILE");
            FileWriter writer = new FileWriter(file);
            writer.write("Hello World\n");
            writer.write("My first writing attempt\n");
            writer.close();

            // Read the file
            System.out.println("READING FILE");
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        }
        catch(IOException e) {
            System.out.println("IO error occur");
        }
    }
}
