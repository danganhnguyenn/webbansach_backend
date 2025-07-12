package vn.nguyen.webbansach_backend.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class GioHang {
    private int maGioHang;
    private Date ngayTao;
    private String diaChiMuaHang;
    private String diaChiNhanHang;
    private double tongTien;
    private List<ChiTietGioHang> danhSachChiTietGioHang;
    private NguoiDung nguoiDung;


}
