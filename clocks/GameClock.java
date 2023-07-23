package clocks;

import actions.Collision;
import game.Snake;

import java.util.concurrent.ThreadLocalRandom;

import static game.Snake.gift;

public class GameClock extends Thread{
    public static boolean running = true;
    public int w= 150;
    public int tickK=0;
    public int tickO;
    public void setW(int w){
        this.w = w;
    }
    public void run(){
        while(running){
            try {
                tickK++;
                tickO++;
                if(tickK >100){
                    this.setW(150);
                    tickK = -9999999;
                    System.out.println("koksWeg"); //debugging
                }
                if(tickO >50){
                    this.setW(150);
                    tickO = -9999999;
                    System.out.println("ODDWeg"); //debugging
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
                    tickK = 0;
                }
                if(Collision.collideOdd()){
                    this.setW(300);
                    tickO = 0;
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