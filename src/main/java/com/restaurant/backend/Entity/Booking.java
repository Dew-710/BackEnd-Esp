package com.restaurant.backend.Entity;



import jakarta.persistence.*;

import lombok.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "booking")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // User = Customer
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private User customer;

    @ManyToOne
    @JoinColumn(name = "table_id")
    private RestaurantTable table;

    private LocalDate date;

    private LocalTime time;

    private int guests;

    @Column(columnDefinition = "TEXT")
    private String note;

    private String status;

    @OneToMany(mappedBy = "booking")
    private List<BookingItem> items;

    @OneToMany(mappedBy = "booking")
    private List<Order> orders;
}
