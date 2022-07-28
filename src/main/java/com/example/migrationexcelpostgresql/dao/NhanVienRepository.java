package com.example.migrationexcelpostgresql.dao;

import com.example.migrationexcelpostgresql.model.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NhanVienRepository extends JpaRepository<NhanVien,Integer> {
}
