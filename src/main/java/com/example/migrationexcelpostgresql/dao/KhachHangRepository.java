package com.example.migrationexcelpostgresql.dao;

import com.example.migrationexcelpostgresql.model.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KhachHangRepository extends JpaRepository<KhachHang,Integer> {
}
