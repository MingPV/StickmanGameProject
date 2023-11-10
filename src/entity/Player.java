package entity;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import main.KeyHandler;

public class Player extends Entity implements EntityFunction {

    private double playerX;
    private double playerY;

    public Player(){

        setDefaultValues();

    }

    public void setDefaultValues() {

        playerX = 100;
        playerY = 100;
        setSpeed(1);
        setDirection("down");
        loadpic();

    }

    public void loadpic(){
        up1 =  new Image("file:res/player/boy_up_1.png");
        up2 =  new Image("file:res/player/boy_up_2.png");
        down1 =  new Image("file:res/player/boy_down_1.png");
        down2 =  new Image("file:res/player/boy_down_2.png");
        left1 =  new Image("file:res/player/boy_left_1.png");
        left2 =  new Image("file:res/player/boy_left_2.png");
        right1 =  new Image("file:res/player/boy_right_1.png");
        right2 =  new Image("file:res/player/boy_right_2.png");
    }

    public void update(){
        // update
        if (KeyHandler.getKeyPressed(KeyCode.W)){
            playerY -= getSpeed();
            setDirection("up");
        }
        if (KeyHandler.getKeyPressed(KeyCode.A)){
            playerX -= getSpeed();
            setDirection("left");
        }
        if (KeyHandler.getKeyPressed(KeyCode.S)){
            playerY += getSpeed();
            setDirection("down");
        }
        if (KeyHandler.getKeyPressed(KeyCode.D)){
            playerX += getSpeed();
            setDirection("right");
        }

        spriteCounter++;
        if(spriteCounter > 20) {
            if(spriteNum == 1) {
                spriteNum = 2;
                //System.out.println(spriteNum);
            }
            else if(spriteNum == 2) {
                spriteNum = 1;
                //System.out.println(spriteNum);
            }
            spriteCounter = 0;
        }

    }



    @Override
    public void draw(GraphicsContext gc) {
        Image playerimage = null;

        switch(getDirection()) {
            case "up":
                if(spriteNum == 1) {
                    playerimage = up1;
                    //System.out.println(spriteNum);
                }
                if(spriteNum == 2) {
                    playerimage = up2;
                    //System.out.println(spriteNum);
                }
                break;
            case "down":
                if(spriteNum == 1) {
                    playerimage = down1;
                }
                if(spriteNum == 2) {
                    playerimage = down2;
                }
                break;
            case "right":
                if(spriteNum == 1) {
                    playerimage = right1;
                }
                if(spriteNum == 2) {
                    playerimage = right2;
                }
                break;
            case "left":
                if(spriteNum == 1) {
                    playerimage = left1;
                }
                if(spriteNum == 2) {
                    playerimage = left2;
                }
                break;
        }

        gc.drawImage(playerimage,playerX,playerY);
    }

    @Override
    public boolean isDestroyed() {
        return false;
    }

    @Override
    public boolean isVisible() {
        return true;
    }

    @Override
    public double getX() {
        return playerX;
    }

    @Override
    public double getY() {
        return playerY;
    }
}
