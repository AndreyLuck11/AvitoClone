package com.example.avitoclone.model;

import com.example.avitoclone.entity.CategoryEntity;
import com.example.avitoclone.entity.ProductEntity;

import java.util.List;
import java.util.stream.Collectors;

public class Category {
    private Long id;
    private String title;
    private List<Product> products;



    public  static  Category toModel(CategoryEntity entity){
        Category model = new Category();
        model.setId(entity.getId());
        model.setTitle(entity.getTitle());
//        model.setProducts(entity.getProduct().stream().map(Product::toModel).collect(Collectors.toList()));
        model.setProducts(entity.getProduct().stream().map(Product::toModel).collect(Collectors.toList()));
        return model;
    }

    public Category() {

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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
