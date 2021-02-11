package com.roganov.entities;

import com.roganov.interfaces.IProduct;
import com.roganov.repositories.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class Cart {

    private ProductRepository repository;
    private final HashMap<Integer,IProduct> cartMap = new HashMap<>();

    public void setRepository(ProductRepository repository){
        this.repository = repository;
    }

    public boolean addProdInCart(int id){
        IProduct product = cartMap.put(id,repository.getProdById(id));
        return product != null;
    }

    public void delProdFromCart(int id){
        cartMap.remove(id);
    }

}
