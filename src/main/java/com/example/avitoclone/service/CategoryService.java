package com.example.avitoclone.service;

import com.example.avitoclone.entity.CategoryEntity;
import com.example.avitoclone.entity.UserEntity;
import com.example.avitoclone.exception.UserAlreadyExistException;
import com.example.avitoclone.exception.UserNotFoundException;
import com.example.avitoclone.model.Category;
import com.example.avitoclone.model.User;
import com.example.avitoclone.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    public CategoryEntity registration(CategoryEntity category){
        return categoryRepo.save(category);
    }

    public Category getOne(Long id) throws UserNotFoundException {
        CategoryEntity category = categoryRepo.findById(id).get();
        if(category == null){
            throw new UserNotFoundException("Пользователь не найден");
        }
        return Category.toModel(category);
    }
}
