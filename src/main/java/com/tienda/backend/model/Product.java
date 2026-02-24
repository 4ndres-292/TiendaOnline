package com.tienda.backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long idProducto;
    
    @Column(name = "name_product", nullable = false, length = 150)
    private String nameProduct;
    
    @Column(name = "amount_product", nullable = false)
    private Integer amountProduct;
    
    @Column(name = "price_product", nullable = false)
    private Double priceProduct;
    
    @Column(name = "description_product", length = 255)
    private String descriptionProduct;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    // Constructor vacío
    public Product() {}
    
    // Constructor con campos
    public Product(String nameProduct, Integer amountProduct, Double priceProduct, String descriptionProduct) {
        this.nameProduct = nameProduct;
        this.amountProduct = amountProduct;
        this.priceProduct = priceProduct;
        this.descriptionProduct = descriptionProduct;
    }
    
    // Getters y Setters
    public Long getIdProducto() {
        return idProducto;
    }
    
    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }
    
    public String getNameProduct() {
        return nameProduct;
    }
    
    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }
    
    public Integer getAmountProduct() {
        return amountProduct;
    }
    
    public void setAmountProduct(Integer amountProduct) {
        this.amountProduct = amountProduct;
    }
    
    public Double getPriceProduct() {
        return priceProduct;
    }
    
    public void setPriceProduct(Double priceProduct) {
        this.priceProduct = priceProduct;
    }
    
    public String getDescriptionProduct() {
        return descriptionProduct;
    }
    
    public void setDescriptionProduct(String descriptionProduct) {
        this.descriptionProduct = descriptionProduct;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }
    
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}