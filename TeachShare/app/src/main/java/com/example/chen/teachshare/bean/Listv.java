package com.example.chen.teachshare.bean;

/**
 * Created by Administrator on 2016/6/1.
 */
public class Listv {
    private String name;
    private int imageId;
    public Listv(String name,int imageId){
        this.name=name;
        this.imageId=imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
