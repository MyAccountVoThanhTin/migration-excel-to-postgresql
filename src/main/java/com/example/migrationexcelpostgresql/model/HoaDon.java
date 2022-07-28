package com.example.migrationexcelpostgresql.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "hoa_don")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class HoaDon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "IDHD", nullable = false)
//    @Pattern(regexp = "^HD-*",
//            message = "Ma Hoa Don Phải Bat Dau Bang NV-")
    private String maHD;

    @Column(name = "ngay_HD", nullable = false)
//    @Pattern(regexp = "^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$",
//            message = "Ngay Lap Hoa Don Phai Dung Dinh Dang dd/mm/yyyy")
    private String ngayHD;

    @Column(name = "thanh_tien", nullable = false)
    private Double thanhTien;

    @Column(name = "hinh_thuc_TT", nullable = false)
    private String hinhThucTT;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "KH_id")
    KhachHang khachHang;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "NV_id")
    NhanVien nhanVien;
}
