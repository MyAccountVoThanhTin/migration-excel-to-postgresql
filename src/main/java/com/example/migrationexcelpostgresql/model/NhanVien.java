package com.example.migrationexcelpostgresql.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "nhanvien")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NhanVien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "IDNV", nullable = false)
//    @Pattern(regexp = "^NV-*",
//            message = "Ma Nhan Vien Phải Bat Dau Bang NV-")
    private String maNV;

    @Column(name = "ten_nv", nullable = false)
    private String tenNhanVien;

    @Column(name = "gioi_tinh", nullable = false)
//    @Pattern(regexp = "^0$|1$",
//            message = "Gioi Tinh Bat Dau Bang 0 Hoac 1")
    private int gioiTinh;

//    @Pattern(regexp = "^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$",
//            message = "Ngay Sinh Phai Dung Dinh Dang dd/mm/yyyy")
    @Column(name = "ngay_sinh", nullable = false)
    private String ngaySinh;

    @Column(name = "dia_chi", nullable = false)
    private String diaChi;

    @Column(name = "sdt", nullable = false)
//    @Pattern(regexp = "^0\\d{9}$",
//            message = "SDT Phai Co 10 So")
    private String sdt;

    @Column(name = "chuc_vu")
    private String chucVu;
}
