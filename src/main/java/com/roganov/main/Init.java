package com.roganov.main;

import com.roganov.service.Product;
import com.roganov.service.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class Init implements CommandLineRunner {
    private final ProductRepository productRepository;

    @Autowired
    public Init(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        this.productRepository.addProduct(new Product(1, "Балалайка", 100.0));
        this.productRepository.addProduct(new Product(2, "Контробас", 300.0));
        this.productRepository.addProduct(new Product(3, "Гитара", 500.0));
    }
}
