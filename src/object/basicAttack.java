package object;

import entity.Player;
import javafx.scene.image.Image;


public abstract class basicAttack {

    public double x, y;
    public double speed;
    public int range;
    public int baserange;

    public Player player;

    public boolean visible;
    public boolean destroyed;


    //public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public Image up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getSpeed() {
        return speed;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setSpriteNum(int spriteNum) {
        this.spriteNum = spriteNum;
    }

    public void setSpriteCounter(int spriteCounter) {
        this.spriteCounter = spriteCounter;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpriteCounter() {
        return spriteCounter;
    }

    public int getSpriteNum() {
        return spriteNum;
    }

    public String getDirection() {
        return direction;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean getVisible(boolean visible){
        return visible;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getRange() {
        return range;
    }

    public int getBaserange() {
        return baserange;
    }

    public void setBaserange(int baserange) {
        this.baserange = baserange;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }


}
