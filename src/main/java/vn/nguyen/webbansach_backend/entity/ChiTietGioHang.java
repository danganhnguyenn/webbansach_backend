package vn.nguyen.webbansach_backend.entity;

import lombok.Data;

@Data
public class ChiTietGioHang {
    private long chiTietGioHang;
    private int soLuong;
    private double giaBan;
    private Sach sach;
    private GioHang gioHang;
}
