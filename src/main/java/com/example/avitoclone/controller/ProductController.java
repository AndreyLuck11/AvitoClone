package com.example.avitoclone.controller;

import com.example.avitoclone.entity.ProductEntity;
import com.example.avitoclone.entity.UserEntity;
import com.example.avitoclone.exception.UserAlreadyExistException;
import com.example.avitoclone.exception.UserNotFoundException;
import com.example.avitoclone.repository.ProductRepo;
import com.example.avitoclone.repository.UserRepo;
import com.example.avitoclone.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity registration(@RequestBody ProductEntity product, @RequestParam Long userId, @RequestParam Long categoryId) {
        try {

            return ResponseEntity.ok(productService.registration(product, userId, categoryId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping
    public ResponseEntity getOneUser(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(productService.getOne(id));
        }  catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(productService.delete(id));
//            return ResponseEntity.ok("Продукт удален");
        }  catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
