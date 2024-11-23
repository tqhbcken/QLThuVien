package QuanLiThuVien.Model;

import java.util.Date;

public class Book {
    private int maSach;
    private String tenSach;
    private String tacGia;
    // private String theLoai;
    private int namXuatBan;
    private String nhaXuatBan;
    private float triGia;
    private Date ngayNhap;

    public Book(int maSach,String tenSach, String tacGia, int namXuatBan, String nhaXuatBan, float triGia, Date ngayNhap) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
            // this.theLoai = theLoai;
        this.namXuatBan = namXuatBan;
        this.nhaXuatBan = nhaXuatBan;
        this.triGia = triGia;
        this.ngayNhap = ngayNhap;
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    // public String getTheLoai() {
    //     return theLoai;
    // }

    // public void setTheLoai(String theLoai) {
    //     this.theLoai = theLoai;
    // }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(int namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }

    public void setNhaXuatBan(String nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    public float getTriGia() {
        return triGia;
    }

    public void setTriGia(float triGia) {
        this.triGia = triGia;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    
    
}
