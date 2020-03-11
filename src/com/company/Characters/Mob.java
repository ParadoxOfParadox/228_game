package com.company.Characters;

import com.company.Characters.Alive;
import org.newdawn.slick.Image;

public class Mob extends Alive {
    static int amount = 0;
    static int killed = 0;

    public Mob(float x, float y, float width, float height, String name, Image img, float hp, float dmg, float speed) {
        super(x, y, width, height, name, img, hp, dmg, speed);
        amount++;
    }

    public static int getAmount() {
        return amount;
    }

    public static int getKilled() {
        return killed;
    }

    public static void setAmount(int amount) {
        Mob.amount = amount;
    }

    public static void setKilled(int killed) {
        Mob.killed = killed;
    }
}
