package com.example.migrationexcelpostgresql.dao;

import com.example.migrationexcelpostgresql.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
