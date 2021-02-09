package com.roganov.controllers;

import com.roganov.entities.Product;
import com.roganov.repositories.ProductRepository;
import com.roganov.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {
    ProductRepository repository;
//    ProductService productService;

//    @Autowired
//    public void setProductService(ProductService productService){
//        this.productService = productService;
//    }

    @Autowired
    public void setRepository(ProductRepository repository){
        this.repository = repository;
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("message", "Hello hello!");
        return "index";
    }

    @GetMapping("/all")
    public String showAllProd(Model model){
//        Product product1 = new Product(12,"test1",8.0);
//        Product product2 = new Product(13,"test2",90.1);
//        List<Product> testList = List.of(product1,product2);
        List<Product> prodList = repository.getProductList();
//        model.addAttribute("testList", testList);
        model.addAttribute("testList", prodList);
        return "product-all";
    }
}
