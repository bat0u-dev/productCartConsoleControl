package com.roganov.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;

@Repository
public class ProductRepository {
    private IProduct product;
    private final HashMap<Integer,IProduct> productMap = new HashMap<>();

    public IProduct getProduct() {
        return product;
    }

    public HashMap<Integer, IProduct> getProductMap() {
        return productMap;
    }

    @PostConstruct
    private void addDefaultProd(){
        this.addProduct(new Product(1, "Балалайка", 100.0));
        this.addProduct(new Product(2, "Контробас", 300.0));
        this.addProduct(new Product(3, "Гитара", 500.0));
    }

    public void setProduct(IProduct product) {
        this.product = product;
    }

    public boolean addProduct(IProduct product){
        this.getProductMap().put(product.getId(),product);
        return true;
    }

    public boolean delProduct(int id){
        this.getProductMap().remove(id);
        return true;
    }

    public void printProdById(int id){
        String title = this.getProdById(id).getTitle();
        double coast = this.getProdById(id).getCoast();
        System.out.println(id + " - " + title + " - " + coast);
    }

    public void printProdList(){
        this.getProductMap().forEach((id,product) -> printProdById(id));
    }

    private Product getProdById(int id){
        return (Product) this.getProductMap().get(id);
    }
}
