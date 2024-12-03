package car_rental_randomize;

import com.github.javafaker.Faker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class Customers {
    public static void main(String[] args) throws SQLException {
        Faker fake = new Faker();
        Random rand = new Random();
        Connection con = DBConnection.getConnection();
        String query = "INSERT INTO customer (name, address, licence_no)" +
                " VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);

        String numbers = "0123456789";

        for (int i = 0; i < 194; i++) {
            String name = fake.name().fullName();
            String address = fake.address().streetAddress();
            String licenceNo = "L";
            for(int k = 0; k < 6; k++) {
                licenceNo += numbers.charAt(rand.nextInt(numbers.length()));
            }

            ps.setString(1, name);
            ps.setString(2, address);
            ps.setString(3, licenceNo);
            ps.executeUpdate();
        }
    }
}
