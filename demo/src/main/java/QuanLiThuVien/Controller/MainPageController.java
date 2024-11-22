package QuanLiThuVien.Controller;

import QuanLiThuVien.utils.AlertUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class MainPageController {
    @FXML
    private BorderPane mainPane; 

    @FXML
    public void handleLogout(ActionEvent event) {
        AlertUtils.showInfoAlert("Đăng xuất", "Bạn đã đăng xuất thành công!");
        // Kiểm tra điều hướng về trang đăng nhập nếu có
    }

    @FXML
    public void handleExit(ActionEvent event) {
        System.exit(0); // Kiểm tra thoát ứng dụng
    }

    @FXML
    public void openBookManagement(ActionEvent event) {
        try {
            // Tải BookManagement.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/QuanLiThuVien/View/BookManagement.fxml"));
            Parent bookManagementView = loader.load(); // Load trang BookManagement

            // Đặt BookManagement vào trung tâm của BorderPane
            mainPane.setCenter(bookManagementView);
        } catch (Exception e) {
            AlertUtils.showErrorAlert("Lỗi", "Không thể tải trang BookManagement");
            e.printStackTrace();
        }
    }

    @FXML
    public void openReaderManagement(ActionEvent event) {
        // Kiểm tra điều hướng tới trang quản lý độc giả
        loadPage("ReaderManagement");
    }

    private void loadPage(String pageName) {
        try {
            javafx.scene.Parent page = javafx.fxml.FXMLLoader.load(getClass().getResource("/view/" + pageName + ".fxml"));
            mainPane.setCenter(page); // Kiểm tra thay đổi nội dung ở giữa
        } catch (Exception e) {
            AlertUtils.showErrorAlert("Lỗi", "Không thể tải trang: " + pageName);
            e.printStackTrace();
        }
    }
}
