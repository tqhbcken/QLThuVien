package QuanLiThuVien.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import QuanLiThuVien.Model.Book;
import QuanLiThuVien.utils.DatabaseUtils;

public class BookDAO {
    public static List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM Sach";
        
        try (Connection conn = DatabaseUtils.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Book book = new Book(
                    rs.getInt("maSach"),
                    rs.getString("tenSach"),
                    rs.getString("tacGia"),
                    rs.getInt("namXuatBan"),
                    rs.getString("nhaXuatBan"),
                    rs.getFloat("triGia"),
                    rs.getDate("ngayNhap")
                );
                books.add(book);
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi lấy danh sách sách: " + e.getMessage());
        }
        return books;
    }

    public static boolean deleteBook(int id) {
        String sql = "DELETE FROM Sach WHERE maSach = ?";
        
        try (Connection conn = DatabaseUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Lỗi khi xóa sách: " + e.getMessage());
            return false;
        }
    }
}
