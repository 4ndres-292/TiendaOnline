package com.tienda.backend.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

import com.tienda.backend.model.Product;
import com.tienda.backend.repository.ProductRepository;
import com.tienda.backend.service.ProductService;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    @Override
    public Product update(Long id, Product product) {
        Product existing = findById(id);

        existing.setNameProduct(product.getNameProduct());
        existing.setAmountProduct(product.getAmountProduct());
        existing.setPriceProduct(product.getPriceProduct());
        existing.setDescriptionProduct(product.getDescriptionProduct());

        return productRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        Product existing = findById(id);
        productRepository.delete(existing);
    }
}