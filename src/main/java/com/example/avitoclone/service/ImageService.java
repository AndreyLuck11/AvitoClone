package com.example.avitoclone.service;

import com.example.avitoclone.entity.ImageEntity;
import com.example.avitoclone.entity.ProductEntity;
import com.example.avitoclone.repository.ImageRepo;
import com.example.avitoclone.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
    @Autowired
    private ImageRepo imageRepo;
    @Autowired
    private ProductRepo productRepo;

    public ImageEntity getProdId(ImageEntity image, Long productId){
        ProductEntity product = productRepo.findById(productId).get();
        image.setProduct(product);
        return imageRepo.save(image);
    }
}
