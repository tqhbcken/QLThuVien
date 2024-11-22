module com.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example to javafx.fxml;
    opens QuanLiThuVien.Main to javafx.graphics;
    opens QuanLiThuVien.Controller to javafx.fxml;
    opens QuanLiThuVien.utils to javafx.fxml;
    opens QuanLiThuVien.DAO to javafx.fxml;
    opens QuanLiThuVien.Model to javafx.fxml;

    exports com.example;
    exports QuanLiThuVien.Main;
    exports QuanLiThuVien.Controller;
    exports QuanLiThuVien.utils;
    exports QuanLiThuVien.DAO;
    exports QuanLiThuVien.Model;
    
}
