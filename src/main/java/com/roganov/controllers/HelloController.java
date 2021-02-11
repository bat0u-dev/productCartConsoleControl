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

    ProductService productService;

    @Autowired
    public void setProductService(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("message", "Hello hello!");
        return "index";
    }

    @GetMapping("/all")
    public String showAllProd(Model model){

        List<Product> prodList = productService.getProductsList();
        model.addAttribute("prodList", prodList);
        return "product-all";
    }
}
