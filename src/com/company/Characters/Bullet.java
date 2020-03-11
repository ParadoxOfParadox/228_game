package com.company.Characters;

import org.newdawn.slick.Image;

public class Bullet extends All implements Moving {
    protected float speed,vx,vy;
    public Bullet(float x, float y, float width, float height, String name, Image img,float speed,float x1,float y1) {
        super(x, y, width, height, name, img);
        this.speed = speed;
        this.vy= (float) (this.speed*(y1-this.y)/(Math.sqrt(Math.pow(this.y-y1,2)+Math.pow(this.x-x1,2))));
        this.vx= (float) (this.speed*(x1-this.x)/(Math.sqrt(Math.pow(this.y-y1,2)+Math.pow(this.x-x1,2))));
    }
    @Override
    public void move() {
        this.x+=this.vx;
        this.y+=this.vy;
    }

    public float getVy() {
        return vy;
    }

    public float getVx() {
        return vx;
    }

    public float getSpeed() {
        return speed;
    }

    public void setVy(float vy) {
        this.vy = vy;
    }

    public void setVx(float vx) {
        this.vx = vx;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
