package game;

import java.util.concurrent.ThreadLocalRandom;

public class LSD {

    int x, y;

    public LSD(){

    }

    public void reset(){
        this.x = ThreadLocalRandom.current().nextInt(0,15);
        this.y = ThreadLocalRandom.current().nextInt(0,15);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}