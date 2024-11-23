package QuanLiThuVien.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class BorrowBooksPageController {

    @FXML
    private TextField readerSearchField;
    
    @FXML
    private TableView<?> availableBooksTable;
    
    @FXML
    private TableView<?> selectedBooksTable;
    
    @FXML
    private DatePicker borrowDatePicker;
    
    @FXML
    private DatePicker returnDatePicker;
    
    @FXML
    private Label bookCountLabel;

    @FXML
    private void handleSearchReader() {
        // Logic tìm kiếm độc giả
    }

    @FXML
    private void handleConfirmBorrow() {
        // Logic xác nhận mượn sách
    }
} 