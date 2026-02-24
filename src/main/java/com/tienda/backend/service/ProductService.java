package com.tienda.backend.service;

import com.tienda.backend.model.Product;
import com.tienda.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;
    
    // CREATE
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
    
    // READ ALL
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    
    // READ ONE
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }
    
    // UPDATE
    public Product updateProduct(Long id, Product productDetails) {
        Product existingProduct = productRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        
        existingProduct.setNameProduct(productDetails.getNameProduct());
        existingProduct.setAmountProduct(productDetails.getAmountProduct());
        existingProduct.setPriceProduct(productDetails.getPriceProduct());
        existingProduct.setDescriptionProduct(productDetails.getDescriptionProduct());
        
        return productRepository.save(existingProduct);
    }
    
    // DELETE
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Producto no encontrado");
        }
        productRepository.deleteById(id);
    }
    
    // Verificar si existe
    public boolean existsById(Long id) {
        return productRepository.existsById(id);
    }
}