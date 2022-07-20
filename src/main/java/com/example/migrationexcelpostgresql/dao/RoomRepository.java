package com.example.migrationexcelpostgresql.dao;

import com.example.migrationexcelpostgresql.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room,Integer> {
}
