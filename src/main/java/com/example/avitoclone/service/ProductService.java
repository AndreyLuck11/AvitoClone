package com.example.avitoclone.service;

import com.example.avitoclone.entity.ProductEntity;
import com.example.avitoclone.entity.UserEntity;
import com.example.avitoclone.exception.UserAlreadyExistException;
import com.example.avitoclone.exception.UserNotFoundException;
import com.example.avitoclone.model.Product;
import com.example.avitoclone.model.User;
import com.example.avitoclone.repository.ProductRepo;
import com.example.avitoclone.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private UserRepo userRepo;

    public Product registration(ProductEntity product, Long userId){
        UserEntity user = userRepo.findById(userId).get();
        product.setUser(user);
        return Product.toModel(productRepo.save(product));
    }

    public Product getOne(Long id){
        ProductEntity product = productRepo.findById(id).get();
        return Product.toModel(product);
    }
//
    public Long delete(Long id){
        productRepo.deleteById(id);
        return id;
    }
}
