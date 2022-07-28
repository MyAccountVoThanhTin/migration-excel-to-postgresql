package com.example.migrationexcelpostgresql.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "menu")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "IDMon", nullable = false)
    @Pattern(regexp = "^M-*",
            message = "Ma Mon Phải Bat Dau Bang M-")
    private String maMon;

    @Column(name = "ten_mon", nullable = false)
    private String tenMon;

    @Column(name = "don_gia", nullable = false)
    private Double donGia;

    @Column(name = "don_vi", nullable = false)
    private String donVi;
}
