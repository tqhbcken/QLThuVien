package QuanLiThuVien.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ReturnBooksPageController {

    @FXML
    private TextField borrowSearchField;
    
    @FXML
    private TableView<?> borrowedBooksTable;
    
    @FXML
    private ComboBox<String> bookConditionComboBox;
    
    @FXML
    private Label penaltyFeeLabel;

    @FXML
    private void handleSearchBorrow() {
        // Logic tìm kiếm phiếu mượn
    }

    @FXML
    private void handleConfirmReturn() {
        // Logic xác nhận trả sách
        // Tính phí phạt nếu cần
    }
} 