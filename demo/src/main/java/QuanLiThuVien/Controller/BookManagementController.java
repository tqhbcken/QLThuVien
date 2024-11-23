package QuanLiThuVien.Controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import QuanLiThuVien.DAO.BookDAO;
import QuanLiThuVien.Model.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
    public class BookManagementController{
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
    private DatePicker ngayNhapField;

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

    @FXML
    private TextField searchField;

    private BookDAO bookDAO;

    public BookManagementController() {
        this.bookDAO = new BookDAO();
    }

    @FXML
    private void initialize() {
        maSachColumn.setCellValueFactory(new PropertyValueFactory<>("maSach"));
        tenSachColumn.setCellValueFactory(new PropertyValueFactory<>("tenSach"));
        tacGiaColumn.setCellValueFactory(new PropertyValueFactory<>("tacGia"));
        namXuatBanColumn.setCellValueFactory(new PropertyValueFactory<>("namXuatBan"));
        nhaXuatBanColumn.setCellValueFactory(new PropertyValueFactory<>("nhaXuatBan"));
        triGiaColumn.setCellValueFactory(new PropertyValueFactory<>("triGia"));
        ngayNhapColumn.setCellValueFactory(new PropertyValueFactory<>("ngayNhap"));

        loadBookData();

        maSachField.setEditable(false);

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
        ngayNhapField.setValue(LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(book.getNgayNhap())));
    }

    @FXML
    private void handleAddButton() {
        try {
            if (tenSachField.getText().isEmpty() || 
                tacGiaField.getText().isEmpty() ||
                namXuatBanField.getText().isEmpty() ||
                nhaXuatBanField.getText().isEmpty() ||
                triGiaField.getText().isEmpty() ||
                ngayNhapField.getValue() == null) {
                
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Cảnh báo");
                alert.setHeaderText(null);
                alert.setContentText("Vui lòng điền đầy đủ thông tin sách!");
                alert.showAndWait();
                return;
            }

            int namXuatBan;
            try {
                namXuatBan = Integer.parseInt(namXuatBanField.getText());
                if (namXuatBan <= 0 || namXuatBan > LocalDate.now().getYear()) {
                    throw new NumberFormatException("Năm xuất bản không hợp lệ");
                }
            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Lỗi");
                alert.setHeaderText(null);
                alert.setContentText("Năm xuất bản phải là số nguyên dương và không được lớn hơn năm hiện tại");
                alert.showAndWait();
                return;
            }

            float triGia;
            try {
                triGia = Float.parseFloat(triGiaField.getText());
                if (triGia <= 0) {
                    throw new NumberFormatException("Trị giá phải lớn hơn 0");
                }
            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Lỗi");
                alert.setHeaderText(null);
                alert.setContentText("Trị giá phải là số dương");
                alert.showAndWait();
                return;
            }

            LocalDate ngayNhapLocalDate = ngayNhapField.getValue();
            if (ngayNhapLocalDate.isAfter(LocalDate.now())) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Lỗi");
                alert.setHeaderText(null);
                alert.setContentText("Ngày nhập không được lớn hơn ngày hiện tại");
                alert.showAndWait();
                return;
            }

            String tenSach = tenSachField.getText();
            String tacGia = tacGiaField.getText();
            String nhaXuatBan = nhaXuatBanField.getText();
            Date ngayNhap = Date.valueOf(ngayNhapLocalDate);
    
            Book newBook = new Book(0, tenSach, tacGia, namXuatBan, nhaXuatBan, triGia, ngayNhap);
    
            boolean success = bookDAO.addBook(newBook);
    
            if (success) {
                loadBookData();
                clearFields();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Thành công");
                alert.setHeaderText(null);
                alert.setContentText("Thêm sách mới thành công!");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Lỗi");
                alert.setHeaderText(null);
                alert.setContentText("Lỗi khi thêm sách mới.");
                alert.showAndWait();
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lỗi");
            alert.setHeaderText(null);
            alert.setContentText("Lỗi không xác định: " + e.getMessage());
            alert.showAndWait();
        }
    }

    private void clearFields() {
        maSachField.clear();
        tenSachField.clear();
        tacGiaField.clear();
        namXuatBanField.clear();
        nhaXuatBanField.clear();
        triGiaField.clear();
        ngayNhapField.setValue(null);
        searchField.clear();
    }

    @FXML
    private void handleEditButton() {
        Book selectedBook = bookTable.getSelectionModel().getSelectedItem();
        
        if (selectedBook == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Cảnh báo");
            alert.setHeaderText(null);
            alert.setContentText("Vui lòng chọn một sách để sửa!");
            alert.showAndWait();
            return;
        }

        try {
            String tenSach = tenSachField.getText();
            String tacGia = tacGiaField.getText();
            int namXuatBan = Integer.parseInt(namXuatBanField.getText());
            String nhaXuatBan = nhaXuatBanField.getText();
            float triGia = Float.parseFloat(triGiaField.getText());
            Date ngayNhap = java.sql.Date.valueOf(ngayNhapField.getValue());

            Book updatedBook = new Book(
                selectedBook.getMaSach(),
                tenSach,
                tacGia, 
                namXuatBan,
                nhaXuatBan,
                triGia,
                ngayNhap
            );

            boolean success = bookDAO.updateBook(updatedBook);

            if (success) {
                loadBookData();
                clearFields();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Thành công");
                alert.setHeaderText(null);
                alert.setContentText("Cập nhật sách thành công!");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Lỗi");
                alert.setHeaderText(null);
                alert.setContentText("Lỗi khi cập nhật sách.");
                alert.showAndWait();
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lỗi");
            alert.setHeaderText(null);
            alert.setContentText("Lỗi định dạng số: " + e.getMessage());
            alert.showAndWait();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lỗi");
            alert.setHeaderText(null);
            alert.setContentText("Lỗi không xác định: " + e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    private void handleDeleteButton() {
        Book selectedBook = bookTable.getSelectionModel().getSelectedItem();
        
        if (selectedBook != null) {
            Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
            confirmAlert.setTitle("Xác nhận xóa");
            confirmAlert.setHeaderText(null);
            confirmAlert.setContentText("Bạn có chắc chắn muốn xóa sách này không?");

            Optional<ButtonType> result = confirmAlert.showAndWait();
            if (result.get() == ButtonType.OK) {
                boolean success = bookDAO.deleteBook(selectedBook.getMaSach());
                
                if (success) {
                    loadBookData();
                    clearFields();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Thành công");
                    alert.setHeaderText(null);
                    alert.setContentText("Xóa sách thành công!");
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Lỗi");
                    alert.setHeaderText(null);
                    alert.setContentText("Lỗi khi xóa sách.");
                    alert.showAndWait();
                }
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Cảnh báo");
            alert.setHeaderText(null);
            alert.setContentText("Vui lòng chọn một sách để xóa.");
            alert.showAndWait();
        }
    }

    @FXML
    private void handleRefreshButton() {
        loadBookData();
        clearFields();
    }

    @FXML
    private void handleSearchButton() {
        String keyword = searchField.getText().trim();
        if (!keyword.isEmpty()) {
            List<Book> books = new ArrayList<>();
            for (Book book : bookDAO.getAllBooks()) {
                if (book.getTenSach().toLowerCase().contains(keyword.toLowerCase()) ||
                    book.getTacGia().toLowerCase().contains(keyword.toLowerCase()) ||
                    String.valueOf(book.getNamXuatBan()).equals(keyword)) {
                    books.add(book);
                }
            }
            if (!books.isEmpty()) {
                ObservableList<Book> bookList = FXCollections.observableArrayList(books);
                bookTable.setItems(bookList);
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Thông báo");
                alert.setHeaderText(null); 
                alert.setContentText("Không tìm thấy sách phù hợp!");
                alert.showAndWait();
                loadBookData();
            }
        } else {
            loadBookData(); // Nếu không có từ khóa, tải lại toàn bộ dữ liệu
        }
    }
}
