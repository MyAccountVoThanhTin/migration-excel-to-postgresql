package com.example.migrationexcelpostgresql.dao;

import com.example.migrationexcelpostgresql.model.Ban;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BanRepository extends JpaRepository<Ban,Integer> {
}
