package entity;

import Inventory.InventoryBar;
import effect.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import main.KeyHandler;
import object.AttackObj;
import profile.ProfileBox;

import java.util.Objects;

import static main.GamePanel.*;
import static scenes.SelectedScene.playerName;
import static scenes.SelectedScene.selectedCharacter;

public class Player extends Entity implements EntityFunction {

    private double playerX;
    private double playerY;
    private int level;
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
    private SuperSeiya superSeiya;
    private boolean isSuperSaiyan;
    private boolean pressedV = false;
    AttackObj attackObj;
    InventoryBar inventoryBar;

    public Player(){

        setDefaultValues();

    }

    public void setDefaultValues() {

        // Swordsman and Sage

        if(Objects.equals(selectedCharacter, "1")){
            setMaxHP(4000);
            setHP(4000);
            setMaxMana(4000);
            setMana(4000);
        }else if (Objects.equals(selectedCharacter, "2")){
            setMaxHP(3000);
            setHP(3000);
            setMaxMana(5000);
            setMana(5000);
        }

        setX(400);
        setY(0);
        setLevel(1);
        setSpeed(1);
        setMaxExp(100);
        setExp(0);
        setMaxSleepiness(10000);
        setSleepiness(0);
        setSleepCounter(0);
        setPoint(0);
        setMonsterDied(0);
        setCanWalkRight(true);
        setCanWalkDown(true);
        setCanWalkUp(true);
        setCanWalkLeft(true);
        setSuperSeiya(false);
        setPressedV(false);
        setSpawned(false);
        setWaitForStart(150);
        setEntityClass(Player.class);
        setDirection("down");
        loadpic();
        setCurrentImage(null);

        setInventoryBar(new InventoryBar());

        setAttackObj(new AttackObj(this));

        setProfileBox(new ProfileBox());

        // START MONSTER
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

        if(Objects.equals(selectedCharacter, "1")){
            setUp1(new Image(String.valueOf(ClassLoader.getSystemResource("player/boy_up_1.png"))));
            setUp2(new Image(String.valueOf(ClassLoader.getSystemResource("player/boy_up_2.png"))));
            setUp3(new Image(String.valueOf(ClassLoader.getSystemResource("player/boy_up_3.png"))));
            setDown1(new Image(String.valueOf(ClassLoader.getSystemResource("player/boy_down_1.png"))));
            setDown2(new Image(String.valueOf(ClassLoader.getSystemResource("player/boy_down_2.png"))));
            setDown3(new Image(String.valueOf(ClassLoader.getSystemResource("player/boy_down_3.png"))));
            setLeft1(new Image(String.valueOf(ClassLoader.getSystemResource("player/boy_left_1.png"))));
            setLeft2(new Image(String.valueOf(ClassLoader.getSystemResource("player/boy_left_2.png"))));
            setLeft3(new Image(String.valueOf(ClassLoader.getSystemResource("player/boy_left_3.png"))));
            setRight1(new Image(String.valueOf(ClassLoader.getSystemResource("player/boy_right_1.png"))));
            setRight2(new Image(String.valueOf(ClassLoader.getSystemResource("player/boy_right_2.png"))));
            setRight3(new Image(String.valueOf(ClassLoader.getSystemResource("player/boy_right_3.png"))));
        }else if (Objects.equals(selectedCharacter, "2")){
            setUp1(new Image(String.valueOf(ClassLoader.getSystemResource("player/boy2_up_1.png"))));
            setUp2(new Image(String.valueOf(ClassLoader.getSystemResource("player/boy2_up_2.png"))));
            setUp3(new Image(String.valueOf(ClassLoader.getSystemResource("player/boy2_up_3.png"))));
            setDown1(new Image(String.valueOf(ClassLoader.getSystemResource("player/boy2_down_1.png"))));
            setDown2(new Image(String.valueOf(ClassLoader.getSystemResource("player/boy2_down_2.png"))));
            setDown3(new Image(String.valueOf(ClassLoader.getSystemResource("player/boy2_down_3.png"))));
            setLeft1(new Image(String.valueOf(ClassLoader.getSystemResource("player/boy2_left_1.png"))));
            setLeft2(new Image(String.valueOf(ClassLoader.getSystemResource("player/boy2_left_2.png"))));
            setLeft3(new Image(String.valueOf(ClassLoader.getSystemResource("player/boy2_left_3.png"))));
            setRight1(new Image(String.valueOf(ClassLoader.getSystemResource("player/boy2_right_1.png"))));
            setRight2(new Image(String.valueOf(ClassLoader.getSystemResource("player/boy2_right_2.png"))));
            setRight3(new Image(String.valueOf(ClassLoader.getSystemResource("player/boy2_right_3.png"))));
        }

        setHPB(new Image(String.valueOf(ClassLoader.getSystemResource("player/hpdemo.png"))));
        setHPB2(new Image(String.valueOf(ClassLoader.getSystemResource("player/HPB_2.png"))));
        setManaB(new Image(String.valueOf(ClassLoader.getSystemResource("player/manademo.png"))));
        setExpB(new Image(String.valueOf(ClassLoader.getSystemResource("player/expdemo.png"))));
        setManaB2(new Image(String.valueOf(ClassLoader.getSystemResource("player/ManaB_2.png"))));
        setSleepB(new Image(String.valueOf(ClassLoader.getSystemResource("player/SleepB.png"))));

    }

    public void update() throws InterruptedException {

        if(!isSpawned()){
            spawn();
        }else{
            if(KeyHandler.getKeyPressed(KeyCode.K)){
                attack();
            }else{
                getAttackObj().setVisible(false);
            }
            // update
            inventoryBar.update(this);
            updatePlayerWalk();
            setAttack(KeyHandler.getKeyPressed(KeyCode.K));
            SaiyanUpdate();
            updateAttackObj();

        }

        // counter
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
        setAutoValues();
        profileBox.update(this);

        //Game over or not
        if(getHP() <= 0 || getSleepiness() >= getMaxSleepiness()){
            GameOver = true;
        }
        if(GameOver){
            System.out.println(" Game Over !!");
        }

    }



    @Override
    public void draw(GraphicsContext gc) {

        setImageWithCounter();

        profileBox.draw(gc);
        drawExp(gc);
        drawSleepiness(gc);
        getAttackObj().draw(gc);

        if(getWaitForStart()<10){
            gc.drawImage(getCurrentImage(),getX(),getY());
            drawHp(gc);
            drawMana(gc);
        }

        // Draw name and levels
        gc.fillText(playerName,getX()-5,getY()-15);
        gc.strokeText("Lv."+getLevel(),getX()-32,getY()-15);
        gc.strokeText("Point : ",680,20);
        gc.fillText(String.valueOf(getPoint()),720,21);

    }

    public void updatePlayerWalk(){
        if (KeyHandler.getKeyPressed(KeyCode.W)){
            if(isCanWalkUP()){
                setY(getY()-getSpeed());
            }
            setDirection("up");
        }
        if (KeyHandler.getKeyPressed(KeyCode.A)){
            if(isCanWalkLeft()){
                setX(getX()-getSpeed());
            }
            setDirection("left");
        }
        if (KeyHandler.getKeyPressed(KeyCode.S)){
            if(isCanWalkDown()){
                setY(getY()+getSpeed());
            }
            setDirection("down");
        }
        if (KeyHandler.getKeyPressed(KeyCode.D)){
            if(isCanWalkRight()){
                setX(getX()+getSpeed());
            }
            setDirection("right");
        }
    }

    public void drawHp(GraphicsContext gc){
        double dot = getMaxHP()/32;
        int dots = (int)(getHP()/dot);
        for(int i=0;i<dots;i++){
            gc.drawImage(getHPB(),getX()+i,getY()-7);

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
            gc.drawImage(getManaB(),getX()+i,getY()-4.5);

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
        double dot2 = getMaxSleepiness()/207;
        int dots2 = (int)(getSleepiness()/dot2);
        for(int i=0;i<dots2-1;i++){
            gc.drawImage(getSleepB(),34+i,97);
        }
    }

    public void SaiyanUpdate(){
        if(!isPressedV() && !isSuperSaiyan()) {
            if (KeyHandler.getKeyPressed(KeyCode.V)) {
                setSuperSaiyan(new SuperSeiya(this));
                Effects.add(getSuperSeiya());
                setSuperSeiya(true);
                setPressedV(true);
                setSpeed(getSpeed()+1);

            }
        }else if(!isPressedV() && isSuperSaiyan()){
            if(KeyHandler.getKeyPressed(KeyCode.V)){
                Effects.remove(getSuperSeiya());
                setSuperSeiya(false);
                setPressedV(true);
                setSpeed(getSpeed()-1);

            }
        }else{
            if(!(KeyHandler.getKeyPressed(KeyCode.V))){
                setPressedV(false);
            }
        }
        if(getMana() == 0 && getSpeed() == 2){
            setSpeed(1);
        }
    }

    public void setAutoValues(){
        if(!isSpawned()){
            setWaitForStart(getWaitForStart()-1);
        }

        setHP(getHP()+0.2);
        setMana(getMana()+0.2);
        setSleepCounter(getSleepCounter()+2);

        if(getSleepCounter() == 20){
            setSleepCounter(0);
            setSleepiness(getSleepiness()+5);
        }
    }

    public void setImageWithCounter(){
        switch(getDirection()) {
            case "up":
                if(spriteNum == 1) {
                    setCurrentImage(getUp1());
                }
                if(spriteNum == 2) {
                    if(isAttack()){
                        setCurrentImage(getUp3());
                    }else{
                        setCurrentImage(getUp2());
                    }
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
    }

    //Setters Getters

    public void setExp(double exp) {
        if(exp >= getMaxExp()){
            exp = 0;
            // change level here
            // change maxEXP here
            setMaxExp(getMaxExp()+40); // add MaxEXP+40
            setMaxHP(getMaxHP()+0.1*(getMaxHP())); // add MaxHP+10%
            setMaxMana(getMaxMana()+0.1*(getMaxMana())); // add MaxMana+10%
            setHP(getMaxHP()); // Re HP
            setMana(getMaxMana()); // Re Mana
            getAttackObj().setDamage(getAttackObj().getDamage()+getAttackObj().getDamage()*0.3); // add damage+30%
            setLevel(getLevel()+1);
        }
        this.exp = exp;
    }
    public void setSleepiness(double sleepiness) {
        if(sleepiness >= getMaxSleepiness()){
            System.out.print("Game Over by sleeping");
            sleepiness = getMaxSleepiness();
        }
        this.sleepiness = sleepiness;
    }

    public void setX(double playerX) {
        if(playerX > 770){
            playerX=770;
        }
        if(playerX < 0){
            playerX =0;
        }
        this.playerX = playerX;
    }

    public void setY(double playerY) {
        if(playerY<0){
            playerY=0;
        }
        if(playerY>600){
            playerY=600;
        }
        this.playerY = playerY;
    }
    public void setHP(double HP) {
        if(HP > getMaxHP()){
            HP = getMaxHP();
        }
        if(getHP()<0){
            HP = 0;
        }
        this.HP = HP;
    }
    public void setMana(double mana) {
        if(mana > getMaxMana()){
            mana = getMaxMana();
        }
        if(mana < 0){
            mana = 0;
        }
        if(mana == 0){
            setSuperSeiya(false);
        }
        this.mana = mana;
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
    public void setHPB(Image HPB) {
        this.HPB = HPB;
    }
    public void setMaxHP(double maxHP) {
        this.maxHP = maxHP;
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
    public void setMaxSleepiness(double maxSleepiness) {
        this.maxSleepiness = maxSleepiness;
    }
    public int getSleepCounter() {
        return sleepCounter;
    }
    public void setSleepCounter(int sleepCounter) {
        this.sleepCounter = sleepCounter;
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
    public void setSuperSaiyan(SuperSeiya superSaiyan) {
        this.superSeiya = superSaiyan;
    }
    public SuperSeiya getSuperSeiya() {
        return superSeiya;
    }
    public void setSuperSeiya(boolean superSeiya) {
        isSuperSaiyan = superSeiya;
    }
    public boolean isSuperSaiyan() {
        return isSuperSaiyan;
    }
    public boolean isPressedV() {
        return pressedV;
    }
    public void setPressedV(boolean pressedV) {
        this.pressedV = pressedV;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
}
