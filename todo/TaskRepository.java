package todo;

import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

public class TaskRepository {

    private DBConnection db;
    private Connection conn;

    public TaskRepository() {
        db = new DBConnection();
        conn = db.getConnection();
    }

    public void displayTodayTasks() {
        if (conn != null) {
            try {
                Statement stmt = conn.createStatement();
                LocalDate today = LocalDate.now();
                ResultSet rs = stmt.executeQuery("SELECT * FROM tasks " +
                        "WHERE completed=0 AND deadline='" + today + "'");
                while (rs.next()) {
                    System.out.println(rs.getInt("id") + " " +
                            rs.getString("name"));
                }
            }
            catch (SQLException e) {
                System.out.println("Tasks cannot be retrieved");
            }
        }
    }

    public void projectTasks() {
        if (conn != null) {
            // Ask user for a project's ID
            Scanner scanner = new Scanner(System.in);
            System.out.print("Project ID: ");
            int id = scanner.nextInt();
            // Query the DB to find the tasks of this project which are incomplete
            try {
                String sql = "SELECT * FROM tasks " +
                "WHERE completed=0 AND projects_id=?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                // Display the tasks
                while (rs.next()) {
                    System.out.println(rs.getInt("id") + " " +
                            rs.getString("name") + " " +
                            rs.getString("deadline"));
                }
            }
            catch (SQLException e) {
                System.out.println("Tasks cannot be retrieved");
            }
        }
    }

    public void addTask() {
        if (conn != null) {
            // Ask user for task name, deadline, and projectID
            Scanner scanner = new Scanner(System.in);
            System.out.print("Task Name: ");
            String name = scanner.next();
            System.out.print("Deadline (YYYY-MM-DD): ");
            String deadline = scanner.next();
            System.out.print("Project ID: ");
            int projectId = scanner.nextInt();
            // Run query to insert new task
            String sql = "INSERT INTO tasks (name, deadline, projects_id) VALUES (?, ?, ?)";
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, name);
                stmt.setString(2, deadline);
                stmt.setInt(3, projectId);
                stmt.executeUpdate();
            }
            catch (SQLException e) {
                System.out.println("Task cannot be inserted");
            }
        }
    }

    public void completeTask() {
        if (conn != null) {
            // Ask user for the task ID
            Scanner scanner = new Scanner(System.in);
            System.out.print("Task ID: ");
            int id = scanner.nextInt();
            // Update task setting completed to 1
            String sql = "UPDATE tasks SET completed=1 WHERE id=?";
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, id);
                stmt.executeUpdate();
            }
            catch (SQLException e) {
                System.out.println("Task cannot be updated");
            }
        }
    }
}
