package QuanLiThuVien.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;

public class MainPageController {
    @FXML
    private BorderPane mainPane;

    @FXML
    public void handleLogout(ActionEvent event) {
        showAlert("Thông báo", "Bạn đã đăng xuất thành công!", Alert.AlertType.INFORMATION);
    }

    @FXML
    public void handleExit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    public void openBookManagement(ActionEvent event) {
        loadPage("BookManagement");
    }

    @FXML
    public void openReaderManagement(ActionEvent event) {
        loadPage("ReaderManagement"); 
    }

    @FXML
    public void openBorrowBooks(ActionEvent event) {
        loadPage("BorrowBooksPage");
    }

    @FXML
    public void openReturnBooks(ActionEvent event) {
        loadPage("ReturnBooksPage");
    }

    @FXML
    public void openReceiptManagement(ActionEvent event) {
        loadPage("ReceiptManagementPage");
    }

    @FXML
    public void openBorrowStats(ActionEvent event) {
        loadPage("BorrowStats");
    }

    @FXML
    public void openFinanceStats(ActionEvent event) {
        loadPage("FinanceStats");
    }

    private void loadPage(String pageName) {
        try {
            String resourcePath = "/QuanLiThuVien/View/" + pageName + ".fxml";
            FXMLLoader loader = new FXMLLoader(getClass().getResource(resourcePath));
            Parent page = loader.load();
            mainPane.setCenter(page);
        } catch (Exception e) {
            e.printStackTrace(); 
            showAlert("Lỗi", "Không thể tải trang " + pageName, Alert.AlertType.ERROR);
        }
    }

    private void showAlert(String title, String content, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
