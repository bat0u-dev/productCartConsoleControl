package com.roganov.service;

import com.roganov.entities.Cart;
import com.roganov.entities.Product;
import com.roganov.interfaces.IProduct;
import com.roganov.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductService {
    private Cart cart;
    private ProductRepository repository;

    @Autowired
    public void setAndInitCart(Cart cart, ProductRepository repository){
        this.cart = cart;
        this.repository = repository;
        this.cart.setRepository(this.repository);
    }

    public List<Product> getProductsList(){
        ArrayList<Product> prodList = new ArrayList<>();
        HashMap<Integer, IProduct> repoProdMap = this.repository.getProductMap();
        for (Map.Entry<Integer, IProduct> entry: repoProdMap.entrySet()) {
            prodList.add((Product) entry.getValue());
        }
        return prodList;
    }


}
