package use_faker;

import net.datafaker.Faker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class FavoriteArtistsUpdate {
    public static void main(String[] args) {
        Connection con = DBConnection.getConnection();

        String [] artists = {"Remos", "Paparizou", "Rouvas", "Sati", "Oikonomopoulos", "Mitropanos", "N/A"};

        Faker faker = new Faker();

        try {
            String query = "UPDATE customers SET favorite_artist=? WHERE id=?";
            PreparedStatement stmt = con.prepareStatement(query);
            Random rand = new Random();

            for(int i = 1; i <= 1000; i++) {
                stmt.setString(1, artists[rand.nextInt(artists.length)]);
                stmt.setInt(2, i);
                stmt.executeUpdate();
            }
            // con.commit();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
