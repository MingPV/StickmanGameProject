package entity;

import Inventory.InventoryBar;
import effect.ShadowEffect;
import effect.diedEffect;
import effect.spawnEffect;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import main.KeyHandler;
import object.AttackObj;
import profile.ProfileBox;

import static main.GamePanel.Effects;
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
    private double sleepiness;
    private double maxSleepiness;
    private int sleepCounter;
    private Image HPB;
    private Image HPB2;
    private Image manaB;
    private Image manaB2;
    private Image expB;
    private Image sleepB;

    private boolean isSpawned;

    private int point;
    private int monsterDied;
    private int waitForStart;
    private ProfileBox profileBox;


    AttackObj attackObj;

    InventoryBar inventoryBar;


    //stamina next!

    public Player(){

        setDefaultValues();

    }

    public void setDefaultValues() {

        setX(400);
        setY(0);
        setSpeed(1);
        setMaxHP(1000);
        setHP(700);
        setMaxExp(100);
        setExp(0);
        setMaxMana(100);
        setMana(20);
        setMaxSleepiness(10000);
        setSleepiness(0);
        setSleepCounter(0);
        setPoint(0);
        setMonsterDied(0);
        setSpawned(false);
        setWaitForStart(150);
        setEntityClass(Player.class);


        setDirection("down");
        loadpic();
        setCurrentImage(null);
        setInventoryBar(new InventoryBar());


        setAttackObj(new AttackObj(this));

        setProfileBox(new ProfileBox());

        monsters.add(new Monster(this));
        monsters.add(new Monster(this));





    }

    public void spawn(){
        if(getWaitForStart() > 10){
            setY(0);
        }else{
            setWaitForStart(-1);
        }
        if(getY() < 300){
            setY(getY()+10);
        }else{
            setSpawned(true);
            Effects.add(new spawnEffect(this));
            setShadowEffect(new ShadowEffect(this));
            Effects.add(getShadowEffect());

        }

    }


    public void loadpic(){

        setUp1(new Image("file:res/player/boy_up_1.png"));
        setUp2(new Image("file:res/player/boy_up_2.png"));
        setUp3(new Image("file:res/player/boy_up_3.png"));
        setDown1(new Image("file:res/player/boy_down_1.png"));
        setDown2(new Image("file:res/player/boy_down_2.png"));
        setDown3(new Image("file:res/player/boy_down_3.png"));
        setLeft1(new Image("file:res/player/boy_left_1.png"));
        setLeft2(new Image("file:res/player/boy_left_2.png"));
        setLeft3(new Image("file:res/player/boy_left_3.png"));
        setRight1(new Image("file:res/player/boy_right_1.png"));
        setRight2(new Image("file:res/player/boy_right_2.png"));
        setRight3(new Image("file:res/player/boy_right_3.png"));

        setHPB(new Image("file:res/player/hpdemo.png"));
        setHPB2(new Image("file:res/player/HPB_2.png"));

        setManaB(new Image("file:res/player/manademo.png"));
        setExpB(new Image("file:res/player/expdemo.png"));

        setManaB2(new Image("file:res/player/ManaB_2.png"));
        setSleepB(new Image("file:res/player/SleepB.png"));

    }

    public void update() throws InterruptedException {

        //if(KeyHandler.getKeyPressed(KeyCode.I)){
        //    GameScene.animation.wait();
        //}


        if(!isSpawned()){
            spawn();
        }else{
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
            setAttack(KeyHandler.getKeyPressed(KeyCode.K));
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
        if(!isSpawned()){
            setWaitForStart(getWaitForStart()-1);
        }


        setSleepCounter(getSleepCounter()+1);

        if(getSleepCounter() == 20){
            setSleepCounter(0);
            setSleepiness(getSleepiness()+1);
        }

        profileBox.update(this);





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
                    if(isAttack()){
                        setCurrentImage(getUp3());
                    }else{
                        setCurrentImage(getUp2());
                    }
                    //System.out.println(spriteNum);
                }
                break;
            case "down":
                if(spriteNum == 1) {
                    setCurrentImage(getDown1());
                }
                if(spriteNum == 2) {
                    if(isAttack()){
                        setCurrentImage(getDown3());
                    }else{
                        setCurrentImage(getDown2());
                    }
                }
                break;
            case "right":
                if(spriteNum == 1) {
                    setCurrentImage(getRight1());
                }
                if(spriteNum == 2) {
                    if(isAttack()){
                        setCurrentImage(getRight3());
                    }else{
                        setCurrentImage(getRight2());
                    }
                }
                break;
            case "left":
                if(spriteNum == 1) {
                    setCurrentImage(getLeft1()
                    );
                }
                if(spriteNum == 2) {
                    if(isAttack()){
                        setCurrentImage(getLeft3());
                    }else{
                        setCurrentImage(getLeft2());
                    }
                }
                break;
        }

        profileBox.draw(gc);
        drawExp(gc);
        drawSleepiness(gc);
        getAttackObj().draw(gc);

        if(getWaitForStart()<10){
            gc.drawImage(getCurrentImage(),getX(),getY());
            drawHp(gc);
            drawMana(gc);
        }


    }

    public void drawHp(GraphicsContext gc){
        double dot = getMaxHP()/32;
        int dots = (int)(getHP()/dot);
        for(int i=0;i<dots;i++){
            gc.drawImage(getHPB(),getX()-6+i,getY()-7);

        }
        double dot2 = getMaxHP()/112;
        int dots2 = (int)(getHP()/dot2);
        for(int i=0;i<dots2-1;i++){
            gc.drawImage(getHPB2(),165+i,29);
        }
    }

    public void drawMana(GraphicsContext gc){
        double dot = getMaxMana()/32;
        int dots = (int)(getMana()/dot);
        for(int i=0;i<dots;i++){
            gc.drawImage(getManaB(),getX()-6+i,getY()-4.5);

        }
        double dot2 = getMaxMana()/112;
        int dots2 = (int)(getMana()/dot2);
        for(int i=0;i<dots2-1;i++){
            gc.drawImage(getManaB2(),165+i,47);
        }
    }
    public void drawExp(GraphicsContext gc){
        double dot = getMaxExp()/800;
        int dots = (int)(getExp()/dot);
        for(int i=0;i<dots;i++){
            gc.drawImage(getExpB(),i,595);
        }
    }
    public void drawSleepiness(GraphicsContext gc){
        double dot = getMaxSleepiness()/800;
        int dots = (int)(getSleepiness()/dot);
        for(int i=0;i<dots;i++){
            gc.drawImage(getManaB(),i,580);
        }
        double dot2 = getMaxSleepiness()/207;
        int dots2 = (int)(getSleepiness()/dot2);
        for(int i=0;i<dots2-1;i++){
            gc.drawImage(getSleepB(),34+i,97);
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

    public double getMaxSleepiness() {
        return maxSleepiness;
    }

    public double getSleepiness() {
        return sleepiness;
    }

    public void setSleepiness(double sleepiness) {
        if(sleepiness >= getMaxSleepiness()){
            System.out.print("Game Over by sleeping");
            sleepiness = getMaxSleepiness();
        }
        this.sleepiness = sleepiness;
    }

    public void setMaxSleepiness(double maxSleepiness) {
        this.maxSleepiness = maxSleepiness;
    }

    public int getSleepCounter() {
        return sleepCounter;
    }

    public void setSleepCounter(int sleepCounter) {
        this.sleepCounter = sleepCounter;
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

    public void setMonsterDied(int monsterDied) {
        this.monsterDied = monsterDied;
    }

    public int getMonsterDied() {
        return monsterDied;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getPoint() {
        return point;
    }

    public boolean isSpawned() {
        return isSpawned;
    }

    public void setSpawned(boolean spawned) {
        isSpawned = spawned;
    }

    public int getWaitForStart() {
        return waitForStart;
    }

    public void setWaitForStart(int waitForStart) {
        this.waitForStart = waitForStart;
    }

    public void setProfileBox(ProfileBox profileBox) {
        this.profileBox = profileBox;
    }
    public ProfileBox getProfileBox() {
        return profileBox;
    }

    public Image getHPB2() {
        return HPB2;
    }

    public void setHPB2(Image HPB2) {
        this.HPB2 = HPB2;
    }

    public Image getManaB2() {
        return manaB2;
    }

    public Image getSleepB() {
        return sleepB;
    }

    public void setSleepB(Image sleepB) {
        this.sleepB = sleepB;
    }

    public void setManaB2(Image manaB2) {
        this.manaB2 = manaB2;
    }
}
