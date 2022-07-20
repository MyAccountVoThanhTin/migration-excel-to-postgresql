package com.example.migrationexcelpostgresql.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;

    @Column(name = "employee_fullname", nullable = false)
    private String fullName;

    @Column(name = "employee_gender", nullable = false)
    private int gender = 0;

    @Column(name = "employee_address", nullable = false)
    private String address;

    @Column(name = "employee_username", nullable = false)
    private String username;

    @Column(name = "employee_password", nullable = false)
    private String password;

    @OneToOne(mappedBy = "employee")
    private Invoice invoice;
}
