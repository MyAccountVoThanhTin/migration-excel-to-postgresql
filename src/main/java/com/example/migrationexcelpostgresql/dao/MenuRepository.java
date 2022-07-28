package com.example.migrationexcelpostgresql.dao;

import com.example.migrationexcelpostgresql.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu,Integer> {
}
