package databases;

import java.sql.*;
import java.util.Scanner;

public class Products
{
    public static void main(String[] args) {
        // Connect to a MySQL Database
        String dbURL = "jdbc:mysql://localhost:3306/test_java";
        String dbUser = "sample";
        String dbPass = "sample";
        try {
            Connection con = DriverManager.getConnection(dbURL, dbUser, dbPass);

            // Query and display all products
            String query = "SELECT * FROM products";
            PreparedStatement statement = con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                System.out.println(rs.getString("description") + " price:"
                + rs.getDouble("price"));
            }

            // Insert some product
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter product name: ");
            String productName = sc.nextLine();
            System.out.print("Enter product price: ");
            double productPrice = sc.nextDouble();

            query = "INSERT INTO products (description, price) VALUES (?, ?)";
            statement = con.prepareStatement(query);
            statement.setString(1, productName);
            statement.setDouble(2, productPrice);
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
