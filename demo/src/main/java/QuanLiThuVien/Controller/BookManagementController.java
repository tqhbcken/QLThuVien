package QuanLiThuVien.Controller;

import QuanLiThuVien.DAO.BookDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class BookManagementController {

    @FXML
    private TextField maSachField;
    @FXML
    private TextField tenSachField;
    @FXML
    private TextField tacGiaField;
    @FXML
    private TextField theLoaiField;
    @FXML
    private TextField namXuatBanField;
    @FXML
    private TextField nhaXuatBanField;
    @FXML
    private TextField triGiaField;
    @FXML
    private TextField ngayNhapField;

    @FXML
    private Button addButton;
    @FXML
    private Button editButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button refreshButton;

    @FXML
    private TableView<?> bookTable;
    @FXML
    private TableColumn<?, ?> maSachColumn;
    @FXML
    private TableColumn<?, ?> tenSachColumn;
    @FXML
    private TableColumn<?, ?> tacGiaColumn;
    @FXML
    private TableColumn<?, ?> theLoaiColumn;
    @FXML
    private TableColumn<?, ?> namXuatBanColumn;
    @FXML
    private TableColumn<?, ?> nhaXuatBanColumn;
    @FXML
    private TableColumn<?, ?> triGiaColumn;
    @FXML
    private TableColumn<?, ?> ngayNhapColumn;

    private BookDAO bookDAO;

    public BookManagementController() {
        bookDAO = new BookDAO();
    }

    @FXML
    private void initialize() {
        // Khởi tạo các cột của bảng
    }

    @FXML
    private void handleAddButton() {
        // Xử lý khi nhấn nút Thêm
    }

    @FXML
    private void handleEditButton() {
        // Xử lý khi nhấn nút Sửa
    }

    @FXML
    private void handleDeleteButton() {
        // Xử lý khi nhấn nút Xóa
    }

    @FXML
    private void handleRefreshButton() {
        // Xử lý khi nhấn nút Làm mới
    }
}
