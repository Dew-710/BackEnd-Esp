package com.restaurant.backend.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@jakarta.persistence.Table(name = "tables")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Table {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "table_name", nullable = false, length = 50)
    private String tableName;

    @Column(nullable = false)
    private Integer capacity;

    @Column(length = 20)
    private String status; // AVAILABLE, etc.

    @OneToMany(mappedBy = "table")
    private List<Booking> bookings;

    @OneToMany(mappedBy = "table")
    private List<Order> orders;
}
