package com.example.hp_ph11.a2017project;

/**
 * Created by hp-ph11 on 28/09/2017.
 */

public class Item {
    private String title;
    private int imageId;
    public Item(String title, int imageId){
        this.title= title;
        this.imageId=imageId;

    }

    public String getTitle() {
        return title;
    }

    public int getImageId() {
        return imageId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}

