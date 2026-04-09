import java.sql.*;

public class TestSQLInjection {

    public static void main(String[] args) throws Exception {

        String username = args[0];

        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost/test",
            "root",
            "password"
        );

        Statement stmt = conn.createStatement();

        // SQL Injection
        String query = "SELECT * FROM users WHERE username = '" + username + "'";

        stmt.executeQuery(query);
    }
}//Test 