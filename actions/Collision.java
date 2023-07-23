package actions;

import clocks.GameClock;
import game.Snake;

import java.util.concurrent.ThreadLocalRandom;

public class Collision {

    public static boolean collideSelf() {
        for(int i = 0; i<Snake.tails.size(); i++){
            if(Snake.head.getX() == Snake.tails.get(i).getX() && Snake.head.getY() == Snake.tails.get(i).getY()
                    && !Snake.tails.get(i).isWait()){
                return true;

            }

        }

        return false;
    }

    public static boolean collideWall() {

        return (Snake.head.getX() < 0 || Snake.head.getX() > 15 || Snake.head.getY() < 0 || Snake.head.getY() > 15);
    }

    public static void collidePickUp() {
        if (Snake.head.getX() == Snake.pickup.getX() && Snake.head.getY() == Snake.pickup.getY()) {
            Snake.pickup.reset();
            Snake.addTail();
            Snake.score +=1;
            if(Snake.score > Snake.bestscore) Snake.bestscore = Snake.score;
            game.Snake.gift.setX(300);
            game.Snake.gift.setX(300);
            game.Snake.koks.setX(300);
            game.Snake.koks.setY(300);
            game.Snake.odd.setX(300);
            game.Snake.odd.setY(300);
            int r = ThreadLocalRandom.current().nextInt(1,4);;
            switch (r){
                case 1:
                    Snake.gift.reset();
                    break;
                case 2:
                    Snake.koks.reset();
                    break;
                case 3:
                    Snake.odd.reset();
                    break;
            }

        }
    }
    public static boolean collideGift() {
        if (Snake.head.getX() == Snake.gift.getX() && Snake.head.getY() == Snake.gift.getY()) {
            Snake.gift.setX(300);
            Snake.gift.setY(300);
            int r = ThreadLocalRandom.current().nextInt(1,4);;
            switch (r){
                case 1:
                    Snake.gift.reset();
                    break;
                case 2:
                    Snake.koks.reset();
                    break;
                case 3:
                    Snake.odd.reset();
                    break;
            }
            return true;
        }
        else{
            return false;
        }

    }
    public static boolean collideKoks() {
        if (Snake.head.getX() == Snake.koks.getX() && Snake.head.getY() == Snake.koks.getY()) {
            Snake.koks.setX(300);
            Snake.koks.setY(300);
            int r = ThreadLocalRandom.current().nextInt(1,4);;
            switch (r){
                case 1:
                    Snake.gift.reset();
                    break;
                case 2:
                    Snake.koks.reset();
                    break;
                case 3:
                    Snake.odd.reset();
                    break;
            }
            return true;
        }
        else{
            return false;
        }

    }
    public static boolean collideOdd() {
        if (Snake.head.getX() == Snake.odd.getX() && Snake.head.getY() == Snake.odd.getY()) {
            Snake.odd.setX(300);
            Snake.odd.setY(300);
            int r = ThreadLocalRandom.current().nextInt(1,4);;
            switch (r){
                case 1:
                    Snake.gift.reset();
                    break;
                case 2:
                    Snake.koks.reset();
                    break;
                case 3:
                    Snake.odd.reset();
                    break;
            }
            return true;
        }
        else{
            return false;
        }

    }

}