package com.example.migrationexcelpostgresql.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name = "customer")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

    @Column(name = "customer_fullname", nullable = false)
    private String fullName;

    @Column(name = "customer_gender", nullable = false)
    private int gender = 0;

    @Column(name = "customer_address", nullable = false)
    private String address;

    @ManyToOne
    @JoinColumn(name="invoice_id")
    private Invoice invoiceCustomer;
}