package com.example.avitoclone.model;

import com.example.avitoclone.entity.ImageEntity;

public class Image {
    private Long id;
//    private String name;
//    private String type;
//    private byte[] image;

    public static Image toModel(ImageEntity entity){
        Image model = new Image();
        model.setId(entity.getId());
//        model.setName(model.getName());
//        model.setType(model.getType());
//        model.setImage(model.getImage());
        return model;
    }

    public Image(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public byte[] getImage() {
//        return image;
//    }
//
//    public void setImage(byte[] image) {
//        this.image = image;
//    }
}
