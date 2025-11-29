package com.restaurant.backend.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@jakarta.persistence.Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id")
    private User customer;

    @ManyToOne(optional = false)
    @JoinColumn(name = "table_id")
    private Table table;

    @ManyToOne(optional = false)
    @JoinColumn(name = "staff_id")
    private User staff;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @Column(name = "order_time")
    private LocalDateTime orderTime;

    @Column(length = 20)
    private String status;

    @Column(precision = 12, scale = 2)
    private BigDecimal total;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> items;

    @OneToOne(mappedBy = "order")
    private Payment payment;
}
