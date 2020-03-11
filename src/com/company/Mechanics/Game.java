package com.company.Mechanics;
import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

import java.io.File;
import java.util.Random;

public class Game extends StateBasedGame {
    public static Music current;
    public static float width = 1920;
    public static float height = 1080;
    public static File[] music;
    public File folderofmusic = new File("src/music");
    public static boolean paused = false;

    public Game(String title) throws SlickException {
        super(title);
        music = folderofmusic.listFiles();
        randommusic();
    }
    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        this.addState(new MenuState());
        this.addState(new GameState());
    }
    static boolean checkaudio(){
        return Game.current.playing();
    }
    static void randommusic() throws SlickException {
        Game.current = new Music(music[new Random().nextInt(music.length)].getPath());
    }
}
