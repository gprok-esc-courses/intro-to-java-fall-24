package todo;

import java.sql.*;
import java.util.Scanner;

public class ProjectRepository {

    private DBConnection db;
    private Connection conn;

    public ProjectRepository() {
        db = new DBConnection();
        conn = db.getConnection();
    }

    public void displayProjects() {
        if (conn != null) {
            try {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM projects");
                while (rs.next()) {
                    System.out.println(rs.getInt("id") +
                            " " + rs.getString("name"));
                }
            }
            catch (SQLException e) {
                System.out.println("Problem reading projects");
            }
        }
    }

    public void addProject() {
        if (conn != null) {
            // Ask user for project name
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            // Run query to insert new project
            try {
                String sql = "INSERT INTO projects (name) VALUES (?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, name);
                stmt.executeUpdate();
            }
            catch (SQLException e) {
                System.out.println("Problem adding project");
            }

        }
    }
}
