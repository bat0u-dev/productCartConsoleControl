package com.roganov.service;

import org.springframework.stereotype.Component;

@Component
public class Product implements IProduct {
    private int id;
    private String title;
    private double coast;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getCoast() {
        return coast;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCoast(double coast) {
        this.coast = coast;
    }

    public Product(int id, String title, double coast) {
        this.id = id;
        this.title = title;
        this.coast = coast;
    }


}
