package entity;

import Inventory.InventoryBar;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import main.GamePanel;
import main.KeyHandler;
import object.AttackObj;
import scenes.GameScene;

import static main.GamePanel.monsters;

public class Player extends Entity implements EntityFunction {

    private double playerX;
    private double playerY;

    private double HP;
    private double maxHP;
    private double mana;
    private double maxMana;
    private double exp;
    private double maxExp;
    private Image HPB;
    private Image manaB;
    private Image expB;
    AttackObj attackObj;

    InventoryBar inventoryBar;

    //stamina next!

    public Player(){

        setDefaultValues();

    }

    public void setDefaultValues() {

        setX(100);
        setY(100);
        setSpeed(1);
        setMaxHP(100);
        setHP(50);
        setMaxExp(100);
        setExp(0);
        setMaxMana(100);
        setMana(20);

        setDirection("down");
        loadpic();
        setCurrentImage(null);
        setInventoryBar(new InventoryBar());


        setAttackObj(new AttackObj(this));

        monsters.add(new Monster(this));
        monsters.add(new Monster(this));



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

        setManaB(new Image("file:res/player/manademo.png"));
        setExpB(new Image("file:res/player/expdemo.png"));

    }

    public void update() throws InterruptedException {

        //if(KeyHandler.getKeyPressed(KeyCode.I)){
        //    GameScene.animation.wait();
        //}



        if(KeyHandler.getKeyPressed(KeyCode.K)){
            attack();
        }else{
            getAttackObj().setVisible(false);
        }
        updateAttackObj();

        inventoryBar.update(this);



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
        drawHp(gc);
        drawMana(gc);
        drawExp(gc);
        getAttackObj().draw(gc);


    }

    public void drawHp(GraphicsContext gc){
        double dot = getMaxHP()/32;
        int dots = (int)(getHP()/dot);
        for(int i=0;i<dots;i++){
            gc.drawImage(getHPB(),getX()-6+i,getY()-7);

        }
    }

    public void drawMana(GraphicsContext gc){
        double dot = getMaxMana()/32;
        int dots = (int)(getMana()/dot);
        for(int i=0;i<dots;i++){
            gc.drawImage(getManaB(),getX()-6+i,getY()-4.5);

        }
    }
    public void drawExp(GraphicsContext gc){
        double dot = getMaxExp()/800;
        int dots = (int)(getExp()/dot);
        for(int i=0;i<dots;i++){
            gc.drawImage(getExpB(),i,595);
        }
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

    public void setMana(double mana) {
        if(mana > getMaxMana()){
            mana = getMaxMana();
        }
        this.mana = mana;
    }

    public void setExp(double exp) {
        if(exp >= getMaxExp()){
            exp = 0;
            // change level here
            // change maxEXP here
        }
        this.exp = exp;
    }

    public void setExpB(Image expB) {
        this.expB = expB;
    }

    public void setMaxExp(double maxExp) {
        this.maxExp = maxExp;
    }

    public void setMaxMana(double maxMana) {
        this.maxMana = maxMana;
    }

    public void setManaB(Image manaB) {
        this.manaB = manaB;
    }

    public double getExp() {
        return exp;
    }

    public double getMana() {
        return mana;
    }

    public double getMaxExp() {
        return maxExp;
    }

    public double getMaxMana() {
        return maxMana;
    }

    public Image getExpB() {
        return expB;
    }

    public Image getManaB() {
        return manaB;
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
    public void updateAttackObj(){
        getAttackObj().update();
    }
    public void attack(){
        getAttackObj().setVisible(true);
    }

    public void setInventoryBar(InventoryBar inventoryBar) {
        this.inventoryBar = inventoryBar;
    }

    public InventoryBar getInventoryBar() {
        return inventoryBar;
    }
}
