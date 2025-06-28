package Day7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** Central place for JDBC URL, user, and password. */
public final class DbUtil {

    /* ⚙️  EDIT THESE THREE VALUES FOR YOUR SETUP */
    private static final String URL  = "jdbc:mysql://localhost:3306/demo?useSSL=false";
    private static final String USER = "root";
    private static final String PASS = "root";

    private DbUtil() { }   // no instances

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
