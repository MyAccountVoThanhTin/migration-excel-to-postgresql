package com.example.migrationexcelpostgresql.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "ban")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ban {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "IDBan", nullable = false)
    private String IDBan;

    @Column(name = "so_nguoi", nullable = false)
    private Integer soNguoi;

    @Column(name = "trang_thai", nullable = false)
//    @Pattern(regexp = "^0$|1$",
//            message = "Trang Thai Bat Dau Bang 0 Hoac 1")
    private String trangThai;
}
