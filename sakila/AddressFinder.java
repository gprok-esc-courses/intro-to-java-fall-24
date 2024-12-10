package sakila;

import java.sql.*;
import java.util.Scanner;

public class AddressFinder {
    public static void main(String[] args) {
        String dbURL = "jdbc:mysql://localhost:3306/sakila";
        String dbUser = "sample";
        String dbPass = "sample";

        try {
            Connection con = DriverManager.getConnection(dbURL, dbUser, dbPass);
            System.out.println("Connected to database");

            Scanner sc = new Scanner(System.in);
            System.out.print("Give me a City: ");
            String city = sc.nextLine();

            String query = "SELECT * FROM address a INNER JOIN city c ON c.city_id=a.city_id WHERE c.city=?";
            System.out.println(query);
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, city);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("address"));
            }
        } catch (SQLException e) {
            System.out.println("Error, DB cannot get connection");
        }
    }
}
