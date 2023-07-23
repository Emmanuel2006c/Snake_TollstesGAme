package clocks;

import actions.Collision;
import game.Snake;

import java.util.concurrent.ThreadLocalRandom;

import static game.Snake.gift;

public class GameClock extends Thread{
    public static boolean running = true;
    public int w= 100;
    public int tick=0;
    public void setW(int w){
        this.w = w;
    }
    public void run(){
        while(running){
            try {
                tick++;
                if(tick >100){
                    this.setW(100);
                }
                sleep(w);
                Snake.move();
                Snake.waitToMove = false;
                Collision.collidePickUp();
                if(Collision.collideGift()){
                    Snake.tails.clear();
                    Snake.score = 0;
                }
                if(Collision.collideKoks()){
                    this.setW(50);
                    tick = 0;
                }
                if(Collision.collideLSD()){
                    this.setW(50);
                    tick = 0;
                }
                if(Collision.collideSelf()){
                    Snake.tails.clear();
                    Snake.score = 0;
                    this.setW(100);
                }
                if(Collision.collideWall()){
                    Snake.tails.clear();
                    Snake.head.setX(7);
                    Snake.head.setY(7);
                    Snake.score = 0;
                    this.setW(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}