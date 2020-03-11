package com.company.Characters;

import org.newdawn.slick.Image;

public abstract class All {
    protected float x,y;
    protected String name;
    protected Image img;
    protected float width,height;
    public All(float x,float y,float width,float height,String name,Image img){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.name = name;
        this.img = img;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public Image getImg() {
        return img;
    }

    public String getName() {
        return name;
    }
}
