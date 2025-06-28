package Day7;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/** Add, list, and search products in the 'product' table. */
public class InventoryApp {

    /* ----- add product ----- */
    public void addProduct(String name, double price, int qty) {
        final String sql = "INSERT INTO product(name, price, quantity) VALUES (?,?,?)";
        try (Connection con = DbUtil.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, name);
            pst.setDouble(2, price);
            pst.setInt(3, qty);
            pst.executeUpdate();
            System.out.println("✔ Product added: " + name);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* ----- list all ----- */
    public void listProducts() {
        final String sql = "SELECT id, name, price, quantity FROM product";
        try (Connection con = DbUtil.getConnection();
             Statement st  = con.createStatement();
             ResultSet rs  = st.executeQuery(sql)) {

            System.out.println("\nID | Name                | Price   | Qty");
            System.out.println("---+---------------------+---------+----");
            while (rs.next()) {
                System.out.printf("%2d | %-20s | Rs %7.2f | %d%n",
                                  rs.getInt("id"),
                                  rs.getString("name"),
                                  rs.getDouble("price"),
                                  rs.getInt("quantity"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* ----- keyword search ----- */
    public void searchProducts(String keyword) {
        final String sql = "SELECT id, name, price, quantity FROM product WHERE name LIKE ?";
        try (Connection con = DbUtil.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, "%" + keyword + "%");

            try (ResultSet rs = pst.executeQuery()) {
                System.out.println("\nSearch results for '" + keyword + "':");
                while (rs.next()) {
                    System.out.printf("%2d | %-20s | Rs %7.2f | %d%n",
                                      rs.getInt("id"),
                                      rs.getString("name"),
                                      rs.getDouble("price"),
                                      rs.getInt("quantity"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* ---------- quick demo ---------- */
    public static void main(String[] args) {
        InventoryApp inv = new InventoryApp();

        inv.addProduct("Pen Drive 32GB", 499.00, 50);
        inv.addProduct("USB-C Cable",    199.00, 40);
        inv.addProduct("Wireless Mouse", 799.00, 25);

        inv.listProducts();
        inv.searchProducts("USB");
    }
}
