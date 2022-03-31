package com.example.avitoclone.repository;

import com.example.avitoclone.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepo extends JpaRepository<ImageEntity, Long> {
    Optional<ImageEntity> findById(Long id);
}

