package com.example.migrationexcelpostgresql.dao;

import com.example.migrationexcelpostgresql.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
