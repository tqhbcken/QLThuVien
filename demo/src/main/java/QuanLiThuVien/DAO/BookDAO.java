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
    public List<Book> getAllBooks() {
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

    public boolean addBook(Book book) { 
        String sql = "INSERT INTO Sach (tenSach, tacGia, namXuatBan, nhaXuatBan, triGia, ngayNhap) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DatabaseUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, book.getTenSach());
            pstmt.setString(2, book.getTacGia());
            pstmt.setInt(3, book.getNamXuatBan());
            pstmt.setString(4, book.getNhaXuatBan());
            pstmt.setFloat(5, book.getTriGia());
            pstmt.setDate(6, new java.sql.Date(book.getNgayNhap().getTime()));
            
            int rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        book.setMaSach(generatedKeys.getInt(1));
                    }
                }
            }
            
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Lỗi khi thêm sách: " + e.getMessage());
            return false;
        }
    }

    public boolean updateBook(Book book) {
        String sql = "UPDATE Sach SET tenSach = ?, tacGia = ?, namXuatBan = ?, nhaXuatBan = ?, triGia = ?, ngayNhap = ? WHERE maSach = ?";
        
        try (Connection conn = DatabaseUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, book.getTenSach());
            pstmt.setString(2, book.getTacGia());
            pstmt.setInt(3, book.getNamXuatBan());
            pstmt.setString(4, book.getNhaXuatBan());
            pstmt.setFloat(5, book.getTriGia());
            pstmt.setDate(6, new java.sql.Date(book.getNgayNhap().getTime()));
            pstmt.setInt(7, book.getMaSach());
            
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Lỗi khi cập nhật sách: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteBook(int id) {
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

    public List<Book> searchBooks(String keyword) {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM Sach WHERE tenSach LIKE ? OR tacGia LIKE ? OR namXuatBan = ?";
        
        try (Connection conn = DatabaseUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + keyword + "%");
            pstmt.setString(2, "%" + keyword + "%");
            
            // Kiểm tra nếu keyword là số, dùng cho năm xuất bản
            try {
                int year = Integer.parseInt(keyword);
                pstmt.setInt(3, year);
            } catch (NumberFormatException e) {
                pstmt.setInt(3, -1); // Giá trị không hợp lệ để không khớp với bất kỳ năm nào
            }
            
            try (ResultSet rs = pstmt.executeQuery()) {
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
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi tìm kiếm sách: " + e.getMessage());
        }
        return books;
    }
}
