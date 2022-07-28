package com.example.migrationexcelpostgresql.dao;

import com.example.migrationexcelpostgresql.model.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HoaDonRepository extends JpaRepository<HoaDon,Integer> {
}
