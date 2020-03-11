package com.company.Mechanics;


import com.company.Mechanics.Game;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Main {
    public static void main(String[] args) throws SlickException {
	    AppGameContainer game1 = new AppGameContainer(new Game("Game"));
        game1.setDisplayMode(1920,1080,true);
        game1.start();
    }
}
