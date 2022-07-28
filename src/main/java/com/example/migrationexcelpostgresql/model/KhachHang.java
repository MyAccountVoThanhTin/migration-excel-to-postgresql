package com.example.migrationexcelpostgresql.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "khach_hang")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class KhachHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "IDKH", nullable = false)
//    @Pattern(regexp = "^KH-*",
//            message = "Ma Khach Hang Phai Bat Dau Bang NV-")
    private String maKH;

    @Column(name = "ten_nv", nullable = false)
    private String tenKH;

    @Column(name = "gioi_tinh", nullable = false)
//    @Pattern(regexp = "^0$|1$",
//            message = "Gioi Tinh Bat Dau Bang 0 Hoac 1")
    private int gioiTinh;

    @Column(name = "ngay_sinh", nullable = false)
//    @Pattern(regexp = "^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$",
//            message = "Ngay Sinh Phai Dung Dinh Dang dd/mm/yyyy")
    private String ngaySinh;

    @Column(name = "sdt", nullable = false)
//    @Pattern(regexp = "^\\d{9}$",
//            message = "SDT Phai Co 10 So")
    private String sdt;

    @Column(name = "vip", nullable = false)
//    @Pattern(regexp = "^0$|1$",
//            message = "Loai Khach Hang Dau Bang 0 Hoac 1")
    private int vip;
}
