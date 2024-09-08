package org.jbunce.orderscatalogsrestfull.persistance.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Getter @Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(nullable = false)
    private String clientName;

    @Column(nullable = false)
    private String clientEmail;

    @Column(nullable = false)
    private String clientPhoneNumber;

    @Column(nullable = false)
    private Long quantity;

    @Column(nullable = false)
    private Double total;

    @Column(nullable = false)
    private LocalDate createdAt;

    @Column(nullable = false)
    private LocalDate updatedAt;

    private LocalDateTime deletedAt;

    @ManyToOne
    @JoinColumn(name = "catalog_id")
    private Catalog catalog;
}
