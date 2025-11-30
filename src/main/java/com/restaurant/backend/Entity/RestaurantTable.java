package com.restaurant.backend.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "tables")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RestaurantTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "table_name", nullable = false, length = 50)
    private String tableName;

    private int capacity;

    @Column(length = 20)
    private String status;

    @OneToMany(mappedBy = "table")
    private List<Booking> bookings;

    @OneToMany(mappedBy = "table")
    private List<Order> orders;
}
