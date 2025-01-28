package use_faker;

import net.datafaker.Faker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class CarRepository {
    public static void insert(Car car) {


        Connection con = DBConnection.getConnection();

        try {
            String query = "INSERT INTO cars (manufacturer, model) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, car.getManufacturer());
            ps.setString(2, car.getModel());
            ps.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insert(int carID, int customerID) {
        Connection con = DBConnection.getConnection();

        try {
            String query = "INSERT INTO customer_cars (cars_id, customers_id) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, carID);
            ps.setInt(2, customerID);
            ps.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println("Maybe duplicate keys");
        }
    }

    public static void generateFakeCars(int n) {
        Faker faker = new Faker();
        for (int i = 0; i < n; i++) {
            Car car = new Car(faker.vehicle().manufacturer(), faker.vehicle().model());
            insert(car);
        }
    }

    public static void allocateCarsToCustomers(int n) {
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            int carId = rand.nextInt(1, 250);
            int customerId = rand.nextInt(1, 1000);
            insert(carId, customerId);
        }
    }
}
