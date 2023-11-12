package entity;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import main.KeyHandler;
import object.AttackObj;

public class Player extends Entity implements EntityFunction {

    private double playerX;
    private double playerY;

    private double HP;
    private double maxHP;
    private Image HPB;

    AttackObj attackObj;

    //stamina next!

    public Player(){

        setDefaultValues();

    }

    public void setDefaultValues() {

        setX(100);
        setY(100);
        setSpeed(1);
        setMaxHP(100);
        setHP(100);
        setDirection("down");
        loadpic();
        setCurrentImage(null);

        setAttackObj(new AttackObj(this));

    }

    public void loadpic(){

        setUp1(new Image("file:res/player/boy_up_1.png"));
        setUp2(new Image("file:res/player/boy_up_2.png"));
        setDown1(new Image("file:res/player/boy_down_1.png"));
        setDown2(new Image("file:res/player/boy_down_2.png"));
        setLeft1(new Image("file:res/player/boy_left_1.png"));
        setLeft2(new Image("file:res/player/boy_left_2.png"));
        setRight1(new Image("file:res/player/boy_right_1.png"));
        setRight2(new Image("file:res/player/boy_right_2.png"));

        setHPB(new Image("file:res/player/hpdemo.png"));

    }

    public void update(){

        updateAttackobj();

        // update
        if (KeyHandler.getKeyPressed(KeyCode.W)){
            setY(getY()-getSpeed());
            setDirection("up");
        }
        if (KeyHandler.getKeyPressed(KeyCode.A)){
            setX(getX()-getSpeed());
            setDirection("left");
        }
        if (KeyHandler.getKeyPressed(KeyCode.S)){
            setY(getY()+getSpeed());
            setDirection("down");
        }
        if (KeyHandler.getKeyPressed(KeyCode.D)){
            setX(getX()+getSpeed());
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

        switch(getDirection()) {
            case "up":
                if(spriteNum == 1) {
                    setCurrentImage(getUp1());
                    //System.out.println(spriteNum);
                }
                if(spriteNum == 2) {
                    setCurrentImage(getUp2());
                    //System.out.println(spriteNum);
                }
                break;
            case "down":
                if(spriteNum == 1) {
                    setCurrentImage(getDown1());
                }
                if(spriteNum == 2) {
                    setCurrentImage(getDown2());
                }
                break;
            case "right":
                if(spriteNum == 1) {
                    setCurrentImage(getRight1());
                }
                if(spriteNum == 2) {
                    setCurrentImage(getRight2());
                }
                break;
            case "left":
                if(spriteNum == 1) {
                    setCurrentImage(getLeft1()
                    );
                }
                if(spriteNum == 2) {
                    setCurrentImage(getLeft2());
                }
                break;
        }

        gc.drawImage(getCurrentImage(),getX(),getY());
        gc.drawImage(getHPB(),getX()-6,getY()-5);
        getAttackObj().draw(gc);
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

    public double getHP() {
        return HP;
    }

    public double getMaxHP() {
        return maxHP;
    }

    public Image getHPB() {
        return HPB;
    }

    public void setHP(double HP) {
        if(HP > getMaxHP()){
            HP = getMaxHP();
        }
        this.HP = HP;
    }

    public void setHPB(Image HPB) {
        this.HPB = HPB;
    }

    public void setMaxHP(double maxHP) {
        this.maxHP = maxHP;
    }

    public void setX(double playerX) {
        this.playerX = playerX;
    }

    public void setY(double playerY) {
        this.playerY = playerY;
    }

    public AttackObj getAttackObj() {
        return attackObj;
    }
    public void setAttackObj(AttackObj attackObj) {
        this.attackObj = attackObj;
    }
    public void updateAttackobj(){
        getAttackObj().update();
    }
}
