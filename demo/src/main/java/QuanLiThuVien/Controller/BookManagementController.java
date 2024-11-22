package QuanLiThuVien.Controller;

import java.sql.Date;
import java.util.List;

import QuanLiThuVien.DAO.BookDAO;
import QuanLiThuVien.Model.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class BookManagementController {
    @FXML
    private TextField maSachField;
    @FXML 
    private TextField tenSachField;
    @FXML
    private TextField tacGiaField;
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
    private TableView<Book> bookTable;
    @FXML
    private TableColumn<Book, String> maSachColumn;
    @FXML
    private TableColumn<Book, String> tenSachColumn;
    @FXML
    private TableColumn<Book, String> tacGiaColumn;
    @FXML
    private TableColumn<Book, Integer> namXuatBanColumn;
    @FXML
    private TableColumn<Book, String> nhaXuatBanColumn;
    @FXML
    private TableColumn<Book, Float> triGiaColumn;
    @FXML
    private TableColumn<Book, Date> ngayNhapColumn;

    private BookDAO bookDAO;

    public BookManagementController() {
        bookDAO = new BookDAO();
    }

    @FXML
    private void initialize() {
        // Khởi tạo các cột của bảng
        maSachColumn.setCellValueFactory(new PropertyValueFactory<>("maSach"));
        tenSachColumn.setCellValueFactory(new PropertyValueFactory<>("tenSach"));
        tacGiaColumn.setCellValueFactory(new PropertyValueFactory<>("tacGia"));
        namXuatBanColumn.setCellValueFactory(new PropertyValueFactory<>("namXuatBan"));
        nhaXuatBanColumn.setCellValueFactory(new PropertyValueFactory<>("nhaXuatBan"));
        triGiaColumn.setCellValueFactory(new PropertyValueFactory<>("triGia"));
        ngayNhapColumn.setCellValueFactory(new PropertyValueFactory<>("ngayNhap"));

        // Tải dữ liệu từ cơ sở dữ liệu
        loadBookData();

        // Đặt TextField của Mã sách không thể chỉnh sửa
        maSachField.setEditable(false);

        // Lắng nghe sự thay đổi lựa chọn trong TableView
        bookTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                loadBookDetails(newValue);
            }
        });
    }

    private void loadBookData() {
        List<Book> books = bookDAO.getAllBooks();
        ObservableList<Book> bookList = FXCollections.observableArrayList(books);
        bookTable.setItems(bookList);
    }

    private void loadBookDetails(Book book) {
        maSachField.setText(String.valueOf(book.getMaSach()));
        tenSachField.setText(book.getTenSach());
        tacGiaField.setText(book.getTacGia());
        namXuatBanField.setText(String.valueOf(book.getNamXuatBan()));
        nhaXuatBanField.setText(book.getNhaXuatBan());
        triGiaField.setText(String.valueOf(book.getTriGia()));
        ngayNhapField.setText(book.getNgayNhap().toString());
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
        // Làm mới dữ liệu
        loadBookData();
    }
}
