package sakila;

import java.sql.*;
import java.util.Scanner;

public class ActorFinder {
    public static void main(String[] args) {
            String dbURL = "jdbc:mysql://localhost:3306/sakila";
            String dbUser = "sample";
            String dbPass = "sample";

            try {
                Connection con = DriverManager.getConnection(dbURL, dbUser, dbPass);
                System.out.println("Connected to database");

                Scanner sc = new Scanner(System.in);
                System.out.print("Give me a letter: ");
                String letter = sc.nextLine();
                System.out.println(letter);

                String query = "SELECT * FROM actor WHERE first_name LIKE ?";
                System.out.println(query);
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setString(1, '%' + letter + '%');

                ResultSet rs = stmt.executeQuery();

                while(rs.next()) {
                    System.out.println(rs.getString("first_name") + " " + rs.getString("last_name"));
                }
            }
            catch (SQLException e) {
                System.out.println("Error, DB cannot get connection");
            }
    }
}
