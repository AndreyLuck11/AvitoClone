package com.example.avitoclone.controller;

import com.example.avitoclone.entity.ImageEntity;
import com.example.avitoclone.repository.ImageRepo;
import com.example.avitoclone.util.ImageUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
@CrossOrigin()
public class ImageController {
    @Autowired
    ImageRepo imageRepo;

    @PostMapping("/upload/image")
    public ResponseEntity<ImageUploadResponse> uplaodImage(@RequestParam("image") MultipartFile file)
            throws IOException {

        imageRepo.save(ImageEntity.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .image(ImageUtility.compressImage(file.getBytes())).build());
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ImageUploadResponse("ImageEntity uploaded successfully: " +
                        file.getOriginalFilename()));
    }

    @GetMapping(path = {"/get/image/info/{id}"})
    public ImageEntity getImageDetails(@PathVariable("name") Long id) throws IOException {

        final Optional<ImageEntity> dbImage = imageRepo.findById(id);

        return ImageEntity.builder()
                .name(dbImage.get().getName())
                .type(dbImage.get().getType())
                .image(ImageUtility.decompressImage(dbImage.get().getImage())).build();
    }

    @GetMapping(path = {"/get/image/{id}"})
    public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws IOException {

        final Optional<ImageEntity> dbImage = imageRepo.findById(id);

        return ResponseEntity
                .ok()
                .contentType(MediaType.valueOf(dbImage.get().getType()))
                .body(ImageUtility.decompressImage(dbImage.get().getImage()));
    }
}
