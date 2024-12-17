package starbuzz;

import java.sql.*;
import java.util.Scanner;

public class CoffeeShop {
    private Scanner scanner;
    private String url;
    private String username;
    private String password;

    public CoffeeShop() {
        scanner = new Scanner(System.in);
        url = "jdbc:mysql://localhost:3306/starbuzz";
        username = "sample";
        password = "sample";
    }

    /**
     * Opens a connection to the database and returns to the caller
     * @return The connection, or null if connection failed
     */
    public Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            return conn;
        }
        catch (SQLException e) {
            System.out.println("SQL Connection problem");
            return null;
        }
    }

    /**
     * Asks user for customer's and product's ids
     * and inserts new order into the database
     * @return True if the operation completed successfully
     */
    public boolean addOrder() {
        Connection c = getConnection();
        if (c == null) {
            return false;
        }
        String query = "INSERT INTO orders (customers_id, products_id, " +
                "date_time, completed) VALUES (?, ?, NOW(), 0)";
        try {
            PreparedStatement st = c.prepareStatement(query);
            System.out.print("Customer ID:");
            int cust_id = scanner.nextInt();
            cleanScanner();
            st.setInt(1, cust_id);
            System.out.print("Product ID:");
            int prod_id = scanner.nextInt();
            cleanScanner();
            st.setInt(2, prod_id);
            st.executeUpdate();
            return true;
        }
        catch (SQLException e) {
            System.out.println("Error inserting order");
            return false;
        }

    }

    /**
     * Ask user for an order's id, and mark this order as complete.
     * @return True if the operation succeeded
     */
    public boolean completeOrder() {
        Connection c = getConnection();
        if (c == null) {
            return false;
        }
        String query = "UPDATE orders SET completed=1 "
                + " WHERE id=?";
        try {
            PreparedStatement st = c.prepareStatement(query);
            System.out.print("Order ID: ");
            int order_id = scanner.nextInt();
            cleanScanner();
            st.setInt(1, order_id);
            st.executeUpdate();
            return true;
        }
        catch (SQLException e) {
            System.out.println("Could not complete order");
            return false;
        }

    }

    /**
     * Retrieves incomplete orders from the database
     * and displays them.
     */
    public void displayIncompleteOrders() {
        Connection c = getConnection();
        if(c != null) {
            String query =
                    "SELECT c.name as cname, p.name as pname, c.phone, " +
                            "o.date_time FROM orders o "
                    + "INNER JOIN customers c ON o.customers_id=c.id "
                    + "INNER JOIN products p ON o.products_id=p.id "
                    + "WHERE completed=0";
            try {
                Statement st = c.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    System.out.println(rs.getString("cname") +
                            ", " + rs.getString("pname") +
                            ", " + rs.getString("phone") +
                            ", " + rs.getString("date_time"));
                }
            }
            catch (SQLException e) {
                System.out.println("Could not retrieve orders");
            }
        }
    }

    /**
     * Cleans any remaining new line in scanner,
     * after a nextInt operation.
     */
    public void cleanScanner() {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }

    /**
     * Displays the menu, gets user's choice and
     * calls the appropriate function.
     */
    public void run() {
        int choice = 0;
        do {
            System.out.println("1. Add Order");
            System.out.println("2. Complete Order");
            System.out.println("3. View Incomplete Orders");
            System.out.println("0. EXIT");
            System.out.println("Select: ");
            choice = scanner.nextInt();
            cleanScanner();
            switch (choice) {
                case 1:
                    if(!addOrder()) {
                        System.out.println("Add order failed");
                    }
                    break;
                case 2:
                    if(!completeOrder()) {
                        System.out.println("Complete order failed");
                    }
                    break;
                case 3:
                    displayIncompleteOrders();
                    break;
                case 0:
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (choice != 0);
    }

    public static void main(String[] args) {
        CoffeeShop coffeeShop = new CoffeeShop();
        coffeeShop.run();
    }
}
