package vn.nguyen.webbansach_backend.entity;

import lombok.Data;

@Data
public class SuDanhGia {
    private long maDanhGia;
    private double diemXepHang;
    private String nhanXet;
    private Sach sach;
    private NguoiDung nguoiDung;

}
