package com.roganov.repositories;

import com.roganov.entities.Product;
import com.roganov.interfaces.IProduct;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository {
    private IProduct product;
    private final HashMap<Integer,IProduct> productMap = new HashMap<>();
    private final List<Product> productList = new ArrayList<>();

    public ProductRepository(){
        productList.add(new Product(5,"testtest",900.1));
    }

    public IProduct getProduct() {
        return product;
    }

    public HashMap<Integer, IProduct> getProductMap() {
        return productMap;
    }

    public List<Product> getProductList(){
        for (Map.Entry<Integer, IProduct> entry: this.productMap.entrySet()) {
            productList.add((Product) entry.getValue());
        }
        return productList;
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
        return this.getProductMap().put(product.getId(),product) != null;

    }

    public boolean delProduct(int id){
        return this.getProductMap().remove(id) != null;
    }

    public boolean printProdById(int id){
        if(this.getProdById(id)!=null){
        String title = this.getProdById(id).getTitle();
        double coast = this.getProdById(id).getCoast();
        System.out.println(id + " - " + title + " - " + coast);}
        else {
            return false;
        }
        return true;
    }

    public void printProdList(){
        this.getProductMap().forEach((id,product) -> printProdById(id));
    }

    public Product getProdById(int id){
        return (Product) this.getProductMap().get(id);
    }
}
