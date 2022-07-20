package com.example.migrationexcelpostgresql.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name = "room")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roomId;

    @Column(name = "room_name", nullable = false)
    private String name;

    @Column(name = "room_price", nullable = false)
    private double price;

    @Column(name = "status_room", nullable = false)
    private int status = 0;
    @ManyToOne
    @JoinColumn(name="invoice_id")
    private Invoice invoiceRoom;
}
