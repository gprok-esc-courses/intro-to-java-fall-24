package use_faker;

import net.datafaker.Faker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class Customers {
    public static void main(String[] args) {
        Connection con = DBConnection.getConnection();

        Faker faker = new Faker();

        try {
            String query = "INSERT INTO customers (name, email, phone, birthdate, cities_id) VALUES (?, ? , ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(query);
            Random rand = new Random();

            for(int i = 0; i < 1000; i++) {
                stmt.setString(1, faker.name().fullName());
                stmt.setString(2, faker.internet().emailAddress());
                stmt.setString(3, faker.phoneNumber().phoneNumber());
                stmt.setString(4, faker.date().birthday(18, 100).toString());
                stmt.setInt(5, rand.nextInt(1, 100));
                stmt.executeUpdate();
            }
            // con.commit();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
