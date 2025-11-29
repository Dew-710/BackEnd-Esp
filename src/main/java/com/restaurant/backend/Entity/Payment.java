package com.restaurant.backend.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "payment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(precision = 12, scale = 2)
    private BigDecimal amount;

    @Column(length = 50)
    private String method;

    @Column(name = "paid_at")
    private LocalDateTime paidAt;
}
