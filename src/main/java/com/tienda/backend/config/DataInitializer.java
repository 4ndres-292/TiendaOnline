package com.tienda.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import lombok.RequiredArgsConstructor;
import com.tienda.backend.repository.ProductRepository;
import com.tienda.backend.model.Product;
import org.springframework.boot.CommandLineRunner;

@Configuration
@RequiredArgsConstructor
public class DataInitializer {

    private final ProductRepository productRepository;

    @Bean
    CommandLineRunner initDatabase() {
        return args -> {

            if (productRepository.count() == 0) {

                productRepository.save(
                        Product.builder()
                                .nameProduct("Laptop Lenovo")
                                .amountProduct(10)
                                .priceProduct(850.00)
                                .descriptionProduct("Laptop 16GB RAM 512GB SSD")
                                .build()
                );

                productRepository.save(
                        Product.builder()
                                .nameProduct("Mouse Gamer")
                                .amountProduct(50)
                                .priceProduct(35.50)
                                .descriptionProduct("Mouse RGB 7200 DPI")
                                .build()
                );
            }
        };
    }
}