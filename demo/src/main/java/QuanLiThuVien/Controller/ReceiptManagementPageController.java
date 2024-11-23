package QuanLiThuVien.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ReceiptManagementPageController {

    @FXML
    private TextField receiptSearchField;
    
    @FXML
    private TableView<?> receiptTable;
    
    @FXML
    private TableColumn<?, ?> receiptIdColumn;
    
    @FXML
    private TableColumn<?, ?> readerColumn;
    
    @FXML
    private TableColumn<?, ?> staffColumn;
    
    @FXML
    private TableColumn<?, ?> debtAmountColumn;
    
    @FXML
    private TableColumn<?, ?> collectedAmountColumn;

    @FXML
    private void handleSearchReceipt() {
        // Logic tìm kiếm phiếu thu
    }

    @FXML
    private void handleCreateReceipt() {
        // Logic lập phiếu thu
    }

    @FXML
    private void handlePrintReceipt() {
        // Logic in phiếu thu
    }
} 