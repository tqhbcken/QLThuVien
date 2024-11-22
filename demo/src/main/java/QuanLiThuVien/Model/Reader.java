package QuanLiThuVien.Model;

import java.util.Date;

public class Reader {
    int maDocGia;
    String hoTenDocGia;
    Date ngaySinh;
    String diaChi;
    String email;
    Date ngayLapThe;
    Date ngayHetHan;
    float tienNo;

    public Reader(int maDocGia, String hoTenDocGia, Date ngaySinh, String diaChi, String email, Date ngayLapThe, Date ngayHetHan, float tienNo) {
        this.maDocGia = maDocGia;
        this.hoTenDocGia = hoTenDocGia;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.email = email;
        this.ngayLapThe = ngayLapThe;
        this.ngayHetHan = ngayHetHan;
        this.tienNo = tienNo;
    }

    public int getMaDocGia() {
        return maDocGia;
    }

    public void setMaDocGia(int maDocGia) {
        this.maDocGia = maDocGia;
    }

    public String getHoTenDocGia() {
        return hoTenDocGia;
    }

    public void setHoTenDocGia(String hoTenDocGia) {
        this.hoTenDocGia = hoTenDocGia;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getNgayLapThe() {
        return ngayLapThe;
    }

    public void setNgayLapThe(Date ngayLapThe) {
        this.ngayLapThe = ngayLapThe;
    }

    public Date getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(Date ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }

    public float getTienNo() {
        return tienNo;
    }

    public void setTienNo(float tienNo) {
        this.tienNo = tienNo;
    }

    
}
