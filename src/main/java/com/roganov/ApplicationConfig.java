package com.roganov;

import com.roganov.service.Cart;
import com.roganov.service.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public ProductRepository repository(){
        return new ProductRepository();
    }

    @Bean
    public Cart cart(){
        return new Cart();
    }
}
