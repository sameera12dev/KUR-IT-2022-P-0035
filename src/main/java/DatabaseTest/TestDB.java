package DatabaseTest;

import java.sql.*;

public class TestDB {
    public static void main(String[] args) {
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database (change password if needed)
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/userdb", "root", "sameera123");

            System.out.println("✅ Connected to MySQL!");
            conn.close();
        } catch (Exception e) {
            System.out.println("❌ Connection failed!");
            e.printStackTrace();
        }
    }
}
