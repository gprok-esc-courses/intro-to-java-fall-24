package databases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRepository {
    public void addProduct(String description, double price) {
        Connection con = DBConnection.getConnection();
        if (con != null) {
            String query = "INSERT INTO products (description, price) VALUES (?, ?)";
            try {
                PreparedStatement st = con.prepareStatement(query);
                st.setString(1, description);
                st.setDouble(2, price);
                st.executeUpdate();
                System.out.println("Product added");
            }
            catch (SQLException e) {
                System.out.println("Product not added");
            }
        }
    }

    public void updateProduct(int id, double price) {
        Connection con = DBConnection.getConnection();
        if (con != null) {
            String query = "UPDATE products SET price = ? WHERE id = ?";
            try {
                PreparedStatement st = con.prepareStatement(query);
                st.setDouble(1, price);
                st.setInt(2, id);
                st.executeUpdate();
                System.out.println("Product updated");
            }
            catch (SQLException e) {
                System.out.println("Product not updated");
            }
        }
    }

    public void deleteProduct(int id) {
        Connection con = DBConnection.getConnection();
        if (con != null) {
            String query = "DELETE FROM products WHERE id = ?";
            try {
                PreparedStatement st = con.prepareStatement(query);
                st.setInt(1, id);
                st.executeUpdate();
                System.out.println("Product deleted");
            }
            catch (SQLException e) {
                System.out.println("Product not deleted");
            }
        }
    }

    public void findProduct(int id) {
        Connection con = DBConnection.getConnection();
        if (con != null) {
            String query = "SELECT * FROM products WHERE id = ?";
            try {
                PreparedStatement st = con.prepareStatement(query);
                st.setInt(1, id);
                ResultSet rs = st.executeQuery();
                if(rs.next()) {
                    System.out.println(rs.getString("description") +
                            " Price: " + rs.getDouble("price"));
                }
                else {
                    System.out.println("Product not found");
                }
            }
            catch (SQLException e) {
                System.out.println("Product not found");
            }
        }
    }
}
