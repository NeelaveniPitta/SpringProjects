package com.ashi.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "products")
@Setter
@Getter
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name", length = 100, nullable = false)
    private String name;

    @Column(length = 100)
    private String description;

    @Column(nullable = false)
    private Double price;

    @Column(name = "category", length = 50)
    private String category;

    @Column(name = "brand", length = 50)
    private String brand;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "Active_SW", nullable = false)
    private Boolean isAvailable;

    @Column(name = "stock_quantity", nullable = false)
    private Integer stock;
}
