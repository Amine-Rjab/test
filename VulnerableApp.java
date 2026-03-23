import java.sql.*;
import java.io.*;
import java.security.MessageDigest;
import java.util.Scanner;

public class VulnerableApp {

    // Hardcoded credentials (vulnerability)
    private static String DB_USER = "admin";
    private static String DB_PASSWORD = "password123";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter username:");
        String username = scanner.nextLine();

        // SQL Injection vulnerability
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb",
                    DB_USER,
                    DB_PASSWORD
            );

            Statement stmt = conn.createStatement();

            String query = "SELECT * FROM users WHERE username = '" + username + "'";

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println("User found: " + rs.getString("username"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Enter system command:");
        String command = scanner.nextLine();

        // Command Injection vulnerability
        try {
            Runtime.getRuntime().exec(command);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Enter filename to read:");
        String filename = scanner.nextLine();

        // Path Traversal vulnerability
        try {
            File file = new File("uploads/" + filename);

            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Weak cryptography (MD5)
        try {

            String password = "secretPassword";

            MessageDigest md = MessageDigest.getInstance("MD5");

            byte[] hash = md.digest(password.getBytes());

            System.out.println("MD5 Hash: " + new String(hash));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}