package object;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import main.KeyHandler;

import entity.Player;


public class AttackObj extends basicAttack implements basicAttackFunction {


    public AttackObj(Player player){

        setDefaultValues(player);

    }

    public void setDefaultValues(Player player) {

        setBaserange(15);

        setX(player.getX());
        setY(player.getY());
        setVisible(false);
        setPlayer(player);

        setSpeed(1);
        setRange(60);
        setDirection(player.getDirection());
        loadpic();


    }

    public void loadpic(){
        up1 =  new Image("file:res/object/atkup_1.png");
        up2 =  new Image("file:res/object/atkup_2.png");
        down1 =  new Image("file:res/object/atkdown_1.png");
        down2 =  new Image("file:res/object/atkdown_2.png");
        left1 =  new Image("file:res/object/atkleft_1.png");
        left2 =  new Image("file:res/object/atkleft_2.png");
        right1 =  new Image("file:res/object/atkright_1.png");
        right2 =  new Image("file:res/object/atkright_2.png");
    }

    public void update(){
        // update

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

        setVisible(KeyHandler.getKeyPressed(KeyCode.K));

    }



    @Override
    public void draw(GraphicsContext gc) {
        Image playerimage = null;

        if(!isVisible()){
            System.out.println("Ming");
            return;
        }

        switch(direction) {
            case "up":
                if(spriteNum == 1) {
                    playerimage = up1;
                    setY(getY()-getRange()/2-5);
                    //System.out.println(spriteNum);
                    //fix
                    setX(getX()-7);
                }
                if(spriteNum == 2) {
                    setY(getY()-getRange()-5);
                    playerimage = up2;
                    //System.out.println(spriteNum);
                    //fix
                    setX(getX()-7);
                }
                break;
            case "down":
                if(spriteNum == 1) {
                    playerimage = down1;
                    setY(getY()+getRange()/2-8);
                    //fix
                    setX(getX()-7);
                }
                if(spriteNum == 2) {
                    setY(getY()+getRange()-8);
                    playerimage = down2;
                    //fix
                    setX(getX()-7);
                }
                break;
            case "right":
                if(spriteNum == 1) {
                    playerimage = right1;
                    setX(getX()+getRange()/2);
                    //fix
                    setY(getY()-7);
                }
                if(spriteNum == 2) {
                    setX(getX()+getRange());
                    playerimage = right2;
                    //fix
                    setY(getY()-7);
                }
                break;
            case "left":
                if(spriteNum == 1) {
                    playerimage = left1;
                    setX(getX()-getRange()/2-10);
                    //fix
                    setY(getY()-7);
                }
                if(spriteNum == 2) {
                    setX(getX()-getRange()-10);
                    playerimage = left2;
                    //fix
                    setY(getY()-7);
                }
                break;
        }


        gc.drawImage(playerimage,x,y);
        setDefaultValues(getPlayer());
    }

    @Override
    public boolean isDestroyed() {
        return destroyed;
    }

    @Override
    public boolean isVisible() {
        return visible;
    }

    @Override
    public void attack() {
        setVisible(true);
    }

    /*public void setX(String d,int px,int x) {
        switch (d){
            case "left":
                super.setX(px-x);
            case "right":
                super.setX(px+x);
        }
    }

    public void setY(String d,int py,int y) {
        switch (d) {
            case "up":
                super.setY(py + y);
            case "down":
                super.setY(py - y);
        }
    }*/
}
