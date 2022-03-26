package com.example.avitoclone.repository;

import com.example.avitoclone.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends CrudRepository<ProductEntity, Long> {
}
