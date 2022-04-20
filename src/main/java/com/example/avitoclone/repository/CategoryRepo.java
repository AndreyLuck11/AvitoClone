package com.example.avitoclone.repository;

import com.example.avitoclone.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepo extends CrudRepository<CategoryEntity, Long> {
    Optional<CategoryEntity> findById(Long id);
}
