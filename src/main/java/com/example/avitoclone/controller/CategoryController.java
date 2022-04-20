package com.example.avitoclone.controller;

import com.example.avitoclone.entity.CategoryEntity;
import com.example.avitoclone.entity.UserEntity;
import com.example.avitoclone.exception.UserAlreadyExistException;
import com.example.avitoclone.exception.UserNotFoundException;
import com.example.avitoclone.service.CategoryService;
import com.example.avitoclone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity registration(@RequestBody CategoryEntity category) {
        try {
            categoryService.registration(category);
            return ResponseEntity.ok("Категория сохранена");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибкаd");
        }
    }

    @GetMapping
    public ResponseEntity getOneCategory(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(categoryService.getOne(id));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }  catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }


}
