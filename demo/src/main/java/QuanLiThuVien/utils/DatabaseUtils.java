package QuanLiThuVien.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtils {
    private static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=QLThuVien;encrypt=true;trustServerCertificate=true;";
    private static final String USER = "sa";
    private static final String PASSWORD = "12";

    public static Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connected to the database successfully!");
            return connection;
        } catch (SQLException e) {
            System.err.println("Failed to connect to the database!");
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        // Test kết nối
        getConnection();
    }
}
