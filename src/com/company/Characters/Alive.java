package com.company.Characters;

import com.company.Mechanics.Game;
import org.newdawn.slick.Image;

import static java.lang.Math.min;

public abstract class Alive extends All implements Moving {
    protected float hp,dmg,speed,vx,vy;
    public Alive(float x, float y, float width, float height, String name, Image img,float hp,float dmg,float speed) {
        super(x, y, width, height, name, img);
        this.hp = hp;
        this.dmg = dmg;
        this.speed = speed;
    }
    @Override
    public void move(){
        this.x = Math.min(this.x+this.vx, Game.width-this.width);
        this.y = min(this.y+this.vy,Game.height-this.height);
    }

    public float getDmg() {
        return dmg;
    }

    public float getHp() {
        return hp;
    }

    public float getSpeed() {
        return speed;
    }

    public float getVx() {
        return vx;
    }

    public float getVy() {
        return vy;
    }

    public void setDmg(float dmg) {
        this.dmg = dmg;
    }

    public void setHp(float hp) {
        this.hp = hp;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void setVx(float vx) {
        this.vx = vx;
    }

    public void setVy(float vy) {
        this.vy = vy;
    }
}
