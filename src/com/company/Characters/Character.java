package com.company.Characters;

import com.company.Characters.Alive;
import org.newdawn.slick.Image;

public class Character extends Alive {
    boolean reload;

    public Character(float x, float y, float width, float height, String name, Image img, float hp, float dmg, float speed) {
        super(x, y, width, height, name, img, hp, dmg, speed);
    }

    public void setReload(boolean reload) {
        this.reload = reload;
    }
    public boolean getReload(){
        return reload;
    }
}
