package com.example.migrationexcelpostgresql.dao;

import com.example.migrationexcelpostgresql.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
}
