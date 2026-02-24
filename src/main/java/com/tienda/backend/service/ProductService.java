package com.tienda.backend.service;

import java.util.List;
import com.tienda.backend.model.Product;

public interface ProductService {

    Product save(Product product);

    List<Product> findAll();

    Product findById(Long id);

    Product update(Long id, Product product);

    void delete(Long id);
}