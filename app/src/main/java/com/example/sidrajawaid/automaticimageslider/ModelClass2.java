package com.example.sidrajawaid.automaticimageslider;

public class ModelClass2 {
    String type;
    int image;
    String name;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ModelClass2(int image, String name,String type) {

        this.image = image;
        this.name = name;
        this.type=type;
    }
}
