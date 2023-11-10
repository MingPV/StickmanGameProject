package entity;

import javafx.scene.image.Image;

import java.awt.image.BufferedImage;

public abstract class Entity {

    private double x, y;
    private double speed;

    //public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public Image up1, up2, down1, down2, left1, left2, right1, right2;
    private String direction;

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

    public int getSpriteCounter() {
        return spriteCounter;
    }

    public int getSpriteNum() {
        return spriteNum;
    }

    public String getDirection() {
        return direction;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setSpriteNum(int spriteNum) {
        this.spriteNum = spriteNum;
    }

    public void setSpriteCounter(int spriteCounter) {
        this.spriteCounter = spriteCounter;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

}
