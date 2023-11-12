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

        setBaseRange(15);

        setX(player.getX());
        setY(player.getY());
        setVisible(false);
        setPlayer(player);

        setSpeed(1);
        setDamage(0.5);
        setRange(60);
        setDirection(player.getDirection());
        loadpic();
        setSizeX(32);
        setSizeY(32);


    }

    public void loadpic(){
        setUp1(new Image("file:res/object/atkup_1.png"));
        setUp2(new Image("file:res/object/atkup_2.png"));
        setDown1(new Image("file:res/object/atkdown_1.png"));
        setDown2(new Image("file:res/object/atkdown_2.png"));
        setLeft1(new Image("file:res/object/atkleft_1.png"));
        setLeft2(new Image("file:res/object/atkleft_2.png"));
        setRight1(new Image("file:res/object/atkright_1.png"));
        setRight2(new Image("file:res/object/atkright_2.png"));

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

        setX(getPlayer().getX());
        setY(getPlayer().getY());
        setDirection(getPlayer().getDirection());

    }



    @Override
    public void draw(GraphicsContext gc) {
        Image playerimage = null;

        if(!isVisible()){
            System.out.println("Ming");
            return;
        }

        switch(getDirection()) {
            case "up":
                if(spriteNum == 1) {
                    playerimage = getUp1();
                    setY(getY()- (double) getRange() /2-5);
                    //System.out.println(spriteNum);
                    //fix
                    setX(getX()-7);
                }
                if(spriteNum == 2) {
                    setY(getY()-getRange()-5);
                    playerimage = getUp2();
                    //System.out.println(spriteNum);
                    //fix
                    setX(getX()-7);
                }
                break;
            case "down":
                if(spriteNum == 1) {
                    playerimage = getDown1();
                    setY(getY()+ (double) getRange() /2-8);
                    //fix
                    setX(getX()-7);
                }
                if(spriteNum == 2) {
                    setY(getY()+getRange()-8);
                    playerimage = getDown2();
                    //fix
                    setX(getX()-7);
                }
                break;
            case "right":
                if(spriteNum == 1) {
                    playerimage = getRight1();
                    setX(getX()+ (double) getRange() /2);
                    //fix
                    setY(getY()-7);
                }
                if(spriteNum == 2) {
                    setX(getX()+getRange());
                    playerimage = getRight2();
                    //fix
                    setY(getY()-7);
                }
                break;
            case "left":
                if(spriteNum == 1) {
                    playerimage = getLeft1();
                    setX(getX()- (double) getRange() /2-10);
                    //fix
                    setY(getY()-7);
                }
                if(spriteNum == 2) {
                    setX(getX()-getRange()-10);
                    playerimage = getLeft2();
                    //fix
                    setY(getY()-7);
                }
                break;
        }


        gc.drawImage(playerimage,getX(),getY());
        setDefaultValues(getPlayer());
    }


}
