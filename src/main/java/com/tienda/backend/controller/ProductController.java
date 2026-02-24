package com.tienda.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.tienda.backend.model.Product;
import com.tienda.backend.service.ProductService;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ProductController {

    private final ProductService productService;

    // CREATE
    @PostMapping
    public Product create(@RequestBody Product product) {
        return productService.save(product);
    }

    // READ ALL
    @GetMapping
    public List<Product> getAll() {
        return productService.findAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return productService.findById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Product update(@PathVariable Long id,
                          @RequestBody Product product) {
        return productService.update(id, product);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }
}