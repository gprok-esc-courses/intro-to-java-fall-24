package todo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private Connection connection;

    public Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/java_todo";
        String user = "sample";
        String password = "sample";
        try {
            connection = DriverManager.getConnection(url, user, password);
            return connection;
        }
        catch (SQLException e) {
            System.out.println("SQL Connection Problem");
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        DBConnection db = new DBConnection();
        Connection connection = db.getConnection();
        if (connection != null) {
            System.out.println("Connection Established");
        }
        else {
            System.out.println("Connection Failed");
        }
    }
}
