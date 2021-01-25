package com.roganov.service;

import org.springframework.stereotype.Component;

@Component
public class Cart {
    private ProductRepository repository;

    public void setRepository(ProductRepository repository){
        this.repository = repository;
    }

    public boolean addProd(IProduct product){
        return repository.addProduct(product);
    }

    public boolean delProd(int id){
        return repository.delProduct(id);
    }

}
