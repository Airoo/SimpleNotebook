package com.example.airo.notebook21;

/**
 * Created by Airo on 17.04.2016.
 */
public class Item {
    private int id;
    private String name;
    private int img;
    private boolean group1;
    private boolean group2;
    private boolean group3;

    public Item(String name, int img) {
        this.name=name;
        this.img=img;
    }

    public Item(Integer id, String name, int img, boolean group1, boolean group2, boolean group3) {
        this.id=id;
        this.name = name;
        this.img = img;
        this.group1 = group1;
        this.group2 = group2;
        this.group3 = group3;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isGroup3() {
        return group3;
    }

    public void setGroup3(boolean group3) {
        this.group3 = group3;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public boolean isGroup1() {
        return group1;
    }

    public void setGroup1(boolean group1) {
        this.group1 = group1;
    }

    public boolean isGroup2() {
        return group2;
    }

    public void setGroup2(boolean group2) {
        this.group2 = group2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
