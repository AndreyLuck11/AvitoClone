package com.example.avitoclone.model;

import com.example.avitoclone.entity.ProductEntity;


public class Product {
    private Long id;
    private String title;
    private String description;

    public  static  Product toModel(ProductEntity entity){
        Product model = new Product();
        model.setId(entity.getId());
        model.setDescription(entity.getDescription());
        model.setTitle(entity.getTitle());
        return model;
    }

    public Product(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
