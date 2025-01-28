package use_faker;

import net.datafaker.Faker;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Cities {

    public static void main(String[] args) {
        Connection con = DBConnection.getConnection();

        Faker faker = new Faker();

        try {
            Statement stmt = con.createStatement();

            for(int i = 0; i < 100; i++) {
                stmt.executeUpdate("INSERT INTO cities (name) VALUES ('" + faker.address().city() + "')");
            }
            // con.commit();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
