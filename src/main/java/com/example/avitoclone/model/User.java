package com.example.avitoclone.model;

import com.example.avitoclone.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class User {
    private  Long id;
    private String username;
    private List<Product> products;

    public  static  User toModel(UserEntity entity){
        User model = new User();
        model.setId(entity.getId());
        model.setUsername(entity.getUsername());
        model.setProducts(entity.getProduct().stream().map(Product::toModel).collect(Collectors.toList()));
        return model;
    }

    public User() {
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
