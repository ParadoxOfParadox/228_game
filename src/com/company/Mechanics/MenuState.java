package com.company.Mechanics;

import com.company.Mechanics.Game;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MenuState extends BasicGameState {
    @Override
    public int getID() {
        return 2;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.drawString("Press k to start", com.company.Mechanics.Game.width/2, com.company.Mechanics.Game.height/2);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        if(gameContainer.getInput().isKeyPressed(Input.KEY_K)){
            Game.current.play();
            stateBasedGame.enterState(1);
        }
    }
}

