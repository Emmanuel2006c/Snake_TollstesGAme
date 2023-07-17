package clock;
import actions.Collision;
import game.Snake;
import gui.*;
import javax.swing.*;
import java.awt.*;

import java.util.concurrent.ThreadLocalRandom;

import static game.Snake.gift;

public class GameClock extends Thread,JLabel{
    point p;
    public static boolean running = true;
public int w= 100;
public int tick=0;
public void setW(int w){
    this.w = w;
}
    public void run(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
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
                    g.setColor(new Color(51, 204, 51));
                    for (int i = 0; i < Snake.tails.size(); i++) {
                        p = Snake.ptc(Snake.tails.get(i).getX(), Snake.tails.get(i).getY());
                        g.fillRect(p.x, p.y, 32, 32);

                        /*lichtkoralisch	# F08080	RGB (240, 128, 128)
                        Olive	# 808000	rgb (128,128,0)
                        Kornblumenblau	# 6495ED	rgb (100, 149, 237)
                       	khaki	# F0E68C	RGB (240, 230, 140)
                        mittelpurpur	# 9370DB	RGB (147, 112, 219)
                        */

                    }
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
