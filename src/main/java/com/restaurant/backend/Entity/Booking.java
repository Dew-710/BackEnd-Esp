package com.restaurant.backend.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@jakarta.persistence.Table(name = "booking")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id")
    private User customer;

    @ManyToOne
    @JoinColumn(name = "table_id")
    private Table table;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private LocalTime time;

    @Column(nullable = false)
    private Integer guests;

    @Column(columnDefinition = "TEXT")
    private String note;

    @Column(length = 20)
    private String status; // PENDING, etc.

    @OneToMany(mappedBy = "booking")
    private List<BookingItem> items;

    @OneToMany(mappedBy = "booking")
    private List<Order> orders;
}
