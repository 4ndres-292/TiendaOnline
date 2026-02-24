package com.tienda.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;

    @Column(nullable = false, length = 150)
    private String nameProduct;

    @Column(nullable = false)
    private Integer amountProduct;

    @Column(nullable = false)
    private Double priceProduct;

    @Column(length = 500)
    private String descriptionProduct;
}