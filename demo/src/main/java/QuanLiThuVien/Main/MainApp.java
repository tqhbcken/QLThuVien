package QuanLiThuVien.Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/QuanLiThuVien/View/MainPage.fxml"));
            Scene scene = new Scene(loader.load());
            primaryStage.setTitle("Hệ thống quản lý thư viện");
            primaryStage.setScene(scene);
            primaryStage.setMaximized(true); // Toàn màn hình
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
