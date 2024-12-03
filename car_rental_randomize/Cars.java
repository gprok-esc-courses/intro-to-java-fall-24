package car_rental_randomize;

import com.github.javafaker.Faker;
import databases.ProductRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class Cars {
    public static void main(String[] args) throws SQLException {
        Faker fake = new Faker();
        Random rand = new Random();
        Connection con = DBConnection.getConnection();
        String query = "INSERT INTO car (identification, plate, model, year_made, color, brand_id, car_category_id)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);

        String [] models = {"Pinto", "Aygo", "Corolla", "Golf", "Taurus",
        "Lanos", "Limo", "Oak", "Cyclop", "Java", "Ibiza", "Century"};

        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";

        for(int i = 0; i < 94; i++) {
            String identification = "G";
            for(int k = 0; k < 15; k++) {
                identification += numbers.charAt(rand.nextInt(numbers.length()));
            }
            String plate = "";
            for(int k = 0; k < 2; k++) {
                plate += chars.charAt(rand.nextInt(chars.length()));
            }
            for(int k = 0;k < 4; k++) {
                plate += numbers.charAt(rand.nextInt(numbers.length()));
            }
            String model = models[rand.nextInt(models.length)];
            int year = rand.nextInt(2015, 2024);
            String color = fake.color().name();
            int brandId = rand.nextInt(1, 6);
            int categoryId = rand.nextInt(1, 4);

            ps.setString(1, identification);
            ps.setString(2, plate);
            ps.setString(3, model);
            ps.setInt(4, year);
            ps.setString(5, color);
            ps.setInt(6, brandId);
            ps.setInt(7, categoryId);

            ps.executeUpdate();
        }
    }
}
