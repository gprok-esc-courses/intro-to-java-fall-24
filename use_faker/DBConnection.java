package use_faker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static String dbURL = "jdbc:mysql://localhost:3306/sample_db";
    private static String dbUser = "sample";
    private static String dbPass = "sample";
    private static Connection conn = null;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
            }
            catch (SQLException e) {
                return null;
            }
        }
        return conn;
    }
}
