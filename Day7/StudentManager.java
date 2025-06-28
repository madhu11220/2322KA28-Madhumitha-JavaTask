package Day7;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/** Inserts and lists students in the 'student' table. */
public class StudentManager {

    /* ---------- CRUD ---------- */

    public void addStudent(String name, int age) {
        final String sql = "INSERT INTO student(name, age) VALUES (?, ?)";
        try (Connection con = DbUtil.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, name);
            pst.setInt(2, age);
            pst.executeUpdate();
            System.out.println("✔ Student added: " + name);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listStudents() {
        final String sql = "SELECT id, name, age FROM student";
        try (Connection con = DbUtil.getConnection();
             Statement st  = con.createStatement();
             ResultSet rs  = st.executeQuery(sql)) {

            System.out.println("\nID | Name           | Age");
            System.out.println("---+----------------+----");
            while (rs.next()) {
                System.out.printf("%2d | %-14s | %d%n",
                                  rs.getInt("id"),
                                  rs.getString("name"),
                                  rs.getInt("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* ---------- quick demo ---------- */
    public static void main(String[] args) {
        StudentManager sm = new StudentManager();
        sm.addStudent("Alice", 20);
        sm.addStudent("Bob",   22);

        sm.listStudents();
    }
}
