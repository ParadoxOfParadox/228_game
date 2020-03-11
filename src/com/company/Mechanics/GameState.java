package com.company.Mechanics;

import com.company.Characters.*;
import com.company.Characters.Character;
import com.company.Mechanics.Game;
import org.newdawn.slick.*;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.Math.min;

public class GameState extends BasicGameState implements MouseListener{
    Character you;
    ArrayList<Bullet> bullets;
    ArrayList<Alive> creatures;
    long start;

    @Override
    public int getID() {
        return 1;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
       you = new Character(com.company.Mechanics.Game.width/2, com.company.Mechanics.Game.height/2,40,60,"Max",new Image("src/images/character.png"),100000,2,(float) 0.35);
       bullets = new ArrayList<>();
       creatures = new ArrayList<>();
    }
    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.drawImage(you.getImg(),you.getX(),you.getY());
        graphics.drawString(String.format("HP: %f",you.getHp()),50,50);
        graphics.drawString(String.format("Killed: %d", Mob.getKilled()),50,100);
        for(int i=0;i<bullets.size();i++){
            Bullet bullet = bullets.get(i);
            graphics.drawImage(bullet.getImg(),bullet.getX(),bullet.getY());
            bullet.setX(bullet.getX()+bullet.getVx());
            bullet.setY(bullet.getY()+bullet.getVy());
            boolean overlap = false;
            for(int j=0;j<creatures.size();j++){
                Alive creature = creatures.get(j);
                if(checkifoverlap(creature,bullet)){
                    creature.setHp(creature.getHp()-you.getDmg());
                    creatures.set(j,creature);
                    overlap = true;
                    break;
                }
            }
            if(!(bullet.getX() >= com.company.Mechanics.Game.width) && !(bullet.getX() <=0) && !(bullet.getY()>= com.company.Mechanics.Game.height) && !(bullet.getY()<=0) && !overlap){
                bullets.set(i, bullet);
            }else{
                bullets.remove(i);
                i--;
            }
        }
        for(int i=0;i<creatures.size();i++){
            Alive creature = creatures.get(i);
            if(creature.getHp()>0) {
                creature.setVy((float) (creature.getSpeed()*(you.getY()-creature.getY())/(Math.sqrt(Math.pow(you.getY()-creature.getY(),2)+Math.pow(you.getX()-creature.getX(),2)))));
                creature.setVx((float) (creature.getSpeed()*(you.getX()-creature.getX())/(Math.sqrt(Math.pow(you.getY()-creature.getY(),2)+Math.pow(you.getX()-creature.getX(),2)))));
                creature.move();
                if(checkifoverlap(you,creature)){
                    you.setHp(you.getHp()-creature.getDmg());
                }
                creatures.set(i,creature);
                graphics.drawImage(creature.getImg(), creature.getX(), creature.getY());
            }else{
                creatures.remove(i);
                Mob.setKilled(Mob.getKilled()+1);
                i--;
                Mob.setAmount(Mob.getAmount()-1);
            }
        }
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        float y = com.company.Mechanics.Game.height-Mouse.getY(),x = Mouse.getX();
        you.setVy((float) (you.getSpeed()*(y-you.getY())/(Math.sqrt(Math.pow(you.getY()-y,2)+Math.pow(you.getX()-x,2)))));
        you.setVx((float) (you.getSpeed()*(x-you.getX())/(Math.sqrt(Math.pow(you.getY()-y,2)+Math.pow(you.getX()-x,2)))));
        you.move();
        if(you.getHp()<=0){
            com.company.Mechanics.Game.current.stop();
            stateBasedGame.enterState(2);
        }
        if(gameContainer.getInput().isKeyPressed(Input.KEY_ESCAPE)){
            com.company.Mechanics.Game.current.stop();
            stateBasedGame.enterState(2);
        }
        if(gameContainer.getInput().isKeyPressed(Input.KEY_SPACE)){
            if(com.company.Mechanics.Game.paused){
                com.company.Mechanics.Game.current.resume();
                com.company.Mechanics.Game.paused = false;
            }else{
                com.company.Mechanics.Game.current.pause();
                com.company.Mechanics.Game.paused = true;
            }
        }
        if(!com.company.Mechanics.Game.checkaudio()){
            com.company.Mechanics.Game.randommusic();
        }
        if(Mouse.isButtonDown(0)){
            if(!you.getReload()) {
                bullets.add(new Bullet(you.getX(), you.getY(),5,5,"bullet",new Image("src/images/bullet.png"),(float) 0.4, Mouse.getX(), com.company.Mechanics.Game.height - Mouse.getY()));
                start = System.currentTimeMillis();
                you.setReload(true);
            }else{
                if(System.currentTimeMillis()-start>=500){
                    you.setReload(false);
                }
            }
        }
        if(Mob.getAmount()<Mob.getKilled()/10+1){
            x=randompos(new Random().nextInt(2), com.company.Mechanics.Game.width,50);
            y=randompos(new Random().nextInt(2), Game.height,50);
            Alive mob = new Mob(x,y,50,50,"ezmob",new Image("src/images/enemy.png"),8,1,(float) 0.05);
            creatures.add(mob);
        }
    }
    float randompos(float a,float size,float indent){
        return a==1 ? size-indent:indent;
    }
    boolean checkifoverlap(All one, All two){
        return (!(one.getX()>two.getX()+two.getWidth()) && !(two.getX()>one.getX()+one.getWidth()) && !(one.getY()+one.getHeight()<two.getY()) && !(two.getY()+two.getHeight()<one.getY()));
    }
}
