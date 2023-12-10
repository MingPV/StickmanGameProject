package entity;

import Item.BluePotion;
import Item.CoffeePotion;
import Item.RedPotion;
import effect.ShadowEffect;
import effect.diedEffect;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Objects;

import static java.lang.Math.pow;
import static main.GamePanel.*;

public class Monster extends Entity implements EntityFunction {

    Player player;

    private double HP;
    private double maxHP;
    private Image HPB;
    private double damage;
    private boolean isAngry;
    private boolean canWalk = true;

    public Monster(){
        // for spawn monster //
    }

    public Monster(Player player){

        setDefaultValues(player);

    }

    public void setDefaultValues(Player player) {

        setPlayer(player);

        setXY(Math.floor(Math.random() *(800)),Math.floor(Math.random() *(600)));
        setSpeed(0.3);
        setMaxHP(200+player.getLevel()*30);
        setHP(getMaxHP());
        setDamage(2+player.getLevel()*0.2);
        setDirection("down");
        setAngry(false);
        setCanWalkDown(true);
        setCanWalkUp(true);
        setCanWalkLeft(true);
        setCanWalkRight(true);
        loadpic();
        setShadowEffect(new ShadowEffect(this));
        Effects.add(getShadowEffect());
        setEntityClass(Monster.class);

    }

    public void loadpic(){
        setUp1(new Image(String.valueOf(ClassLoader.getSystemResource("monster/monster_up_1.png"))));
        setUp2(new Image(String.valueOf(ClassLoader.getSystemResource("monster/monster_up_2.png"))));
        setUp3(new Image(String.valueOf(ClassLoader.getSystemResource("monster/monster_up_3.png"))));
        setDown1(new Image(String.valueOf(ClassLoader.getSystemResource("monster/monster_down_1.png"))));
        setDown2(new Image(String.valueOf(ClassLoader.getSystemResource("monster/monster_down_2.png"))));
        setDown3(new Image(String.valueOf(ClassLoader.getSystemResource("monster/monster_down_3.png"))));
        setLeft1(new Image(String.valueOf(ClassLoader.getSystemResource("monster/monster_left_1.png"))));
        setLeft2(new Image(String.valueOf(ClassLoader.getSystemResource("monster/monster_left_2.png"))));
        setLeft3(new Image(String.valueOf(ClassLoader.getSystemResource("monster/monster_left_3.png"))));
        setRight1(new Image(String.valueOf(ClassLoader.getSystemResource("monster/monster_right_1.png"))));
        setRight2(new Image(String.valueOf(ClassLoader.getSystemResource("monster/monster_right_2.png"))));
        setRight3(new Image(String.valueOf(ClassLoader.getSystemResource("monster/monster_right_3.png"))));

        setHPB(new Image(String.valueOf(ClassLoader.getSystemResource("player/hpdemored.png"))));

    }

    public void update(Player player){
        // update

        setPlayer(player);

        //if monster died player get EXP
        if(getHP() <= 0){
            delete();
            player.setExp(player.getExp()+15);
        }

        //set default canWalk
        setCanWalk(true);
        MonsterWalkUpdate();

        if(isAngry){
            spriteCounter++;
            if(spriteCounter > 20) {
                if(spriteNum == 1) {
                    spriteNum = 2;
                    //System.out.println(spriteNum);
                }
                else if(spriteNum == 2) {
                    spriteNum = 3;
                    //System.out.println(spriteNum);
                }else if(spriteNum == 3){
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
    }

    public void Walk(){
        if (player.getY()<getY()){
            setY(getY()-getSpeed());
            setDirection("up");
        }
        if (player.getX()<getX()){
            setX(getX()-getSpeed());
            setDirection("left");
        }
        if (player.getY()>getY() ){
            setY(getY()+getSpeed());
            setDirection("down");
        }
        if (player.getX()>getX()){
            setX(getX()+getSpeed());
            setDirection("right");
        }
    }

    public void Attack(){
        if(Objects.equals(player.getDirection(), "right")){
            if(getX() >= player.getAttackObj().getX() && getX() <= player.getAttackObj().getX()+ player.getAttackObj().getRange() && getY() >= player.getAttackObj().getY() && getY()<= player.getAttackObj().getY()+player.getAttackObj().getSizeY()/2 && player.getAttackObj().isVisible()){
                setHP(getHP()-player.getAttackObj().getDamage());
            }
        }else if(Objects.equals(player.getDirection(), "left")){
            if(getX() <= player.getAttackObj().getX() && getX() >= player.getAttackObj().getX()- player.getAttackObj().getRange() && getY() >= player.getAttackObj().getY() && getY()<= player.getAttackObj().getY()+player.getAttackObj().getSizeY()/2 && player.getAttackObj().isVisible()){
                setHP(getHP()-player.getAttackObj().getDamage());
            }
        }else if(Objects.equals(player.getDirection(), "down")){
            if(getX() <= player.getX()+10 && getX()>=player.getX()-10 && getY()>= player.getY() && getY()<= player.getY()+player.getAttackObj().getRange() && player.getAttackObj().isVisible()){
                setHP(getHP()-player.getAttackObj().getDamage());
            }
        }else if(Objects.equals(player.getDirection(), "up")){
            if(getX() <= player.getX()+20 && getX()>=player.getX()-20 && getY()<= player.getY() && getY()>= player.getY()-player.getAttackObj().getRange() && player.getAttackObj().isVisible()){
                setHP(getHP()-player.getAttackObj().getDamage());
            }
        }
    }

    public void AttackMorePower(){
        if(getX()< player.getX()){
            if(player.getAttackObj().isVisible() && Objects.equals(player.getDirection(), "left")){
                setHP(getHP()-player.getAttackObj().getDamage());
            }
        }
        if(getX()> player.getX()){
            if(player.getAttackObj().isVisible() && Objects.equals(player.getDirection(), "right")){
                setHP(getHP()-player.getAttackObj().getDamage());
            }
        }
        if(getY()< player.getY()){
            if(player.getAttackObj().isVisible() && Objects.equals(player.getDirection(), "up")){
                setHP(getHP()-player.getAttackObj().getDamage());
            }
        }
        if(getY()> player.getY()){
            if(player.getAttackObj().isVisible() && Objects.equals(player.getDirection(), "down")){
                setHP(getHP()-player.getAttackObj().getDamage());
            }
        }
    }

    @Override
    public void draw(GraphicsContext gc) {

        switch(getDirection()) {
            case "up":
                SetImageForDrawUp();
                break;
            case "down":
                SetImageForDrawDown();
                break;
            case "right":
                SetImageForDrawRight();
                break;
            case "left":
                SetImageForDrawLeft();
        }

        gc.drawImage(getCurrentImage(),getX(),getY());
        drawHp(gc);

    }

    public void SetImageForDrawLeft(){
        if(spriteNum == 1) {
            setCurrentImage(getLeft1());
        }
        if(spriteNum == 2) {
            setCurrentImage(getLeft2());
        }
        if(spriteNum == 3){
            setCurrentImage(getLeft3());
        }
    }
    public void SetImageForDrawRight(){
        if(spriteNum == 1) {
            setCurrentImage(getRight1());
        }
        if(spriteNum == 2) {
            setCurrentImage(getRight2());
        }
        if(spriteNum == 3){
            setCurrentImage(getRight3());
        }
    }
    public void SetImageForDrawDown(){
        if(spriteNum == 1) {
            setCurrentImage(getDown1());
        }
        if(spriteNum == 2) {
            setCurrentImage(getDown2());
        }
        if(spriteNum == 3){
            setCurrentImage(getDown3());
        }
    }
    public void SetImageForDrawUp(){
        if(spriteNum == 1) {
            setCurrentImage(getUp1());
        }
        if(spriteNum == 2) {
            setCurrentImage(getUp2());
        }
        if(spriteNum == 3){
            setCurrentImage(getUp3());
        }
    }

    public void delete(){
        Effects.add(new diedEffect(this,player));
        switch (spriteNum){
            case 1:
                itemOnFloors.add(new CoffeePotion(this,player));
                break;
            case 2:
                itemOnFloors.add(new RedPotion(this,player));
                break;
            case 3:
                itemOnFloors.add(new BluePotion(this,player));
                break;
        }
        if(spriteNum == 1){
            monsters.add(new Monster(player));  // random generate 2 monsters if 1 monster died
        }
        monsters.add(new Monster(player));
        if(player.getMonsterDied() == 10){
            player.setMonsterDied(0);
            monsters.add(new Boss(player));
        }
        Effects.remove(getShadowEffect());
        monsters.remove(this);
        player.setPoint(player.getPoint()+15);
        player.setMonsterDied(player.getMonsterDied()+1);
    }

    public void updateAll(ArrayList<Monster> monsters){
        if(!monsters.isEmpty()){
            for (int i=0;i<monsters.size();i++) {
                switch (String.valueOf(monsters.get(i).getEntityClass())){
                    case "class entity.Monster" :
                        monsters.get(i).update(player);
                        break;
                    case "class entity.Boss" :
                        monsters.get(i).update(player);
                        break;
                }
            }
        }
    }

    public void drawAll(ArrayList<Monster> monsters, GraphicsContext gc){
        if(!monsters.isEmpty()){
            for (int i=0;i<monsters.size();i++) {
                switch (String.valueOf(monsters.get(i).getEntityClass())){
                    case "class entity.Monster" :
                        ((Monster) monsters.get(i)).draw(gc);
                        break;
                    case "class entity.Boss" :
                        ((Boss) monsters.get(i)).draw(gc);
                        break;
                }
            }
        }
    }

    public void setXY(double x,double y){
        while(x<330&&y<130){
            x = Math.floor(Math.random() *(800));
            y = Math.floor(Math.random() *(600));
        }
        if(x>770){
            x=770;
        }
        if(x<30){
            x=30;
        }
        if(y<20){
            y=20;
        }
        if(y>480){
            y=480;
        }
        setX(x);
        setY(y);
    }

    public void MonsterWalkUpdate(){
        if(pow((player.getX()-getX()),2) + pow(player.getY()-getY(),2) < 800){
            player.setHP(player.getHP()-getDamage());
            setCanWalk(false);
        }

        if(pow((player.getX()-getX()),2) + pow(player.getY()-getY(),2) < 70000){

            setAngry(true);
            if(player.getWaitForStart()<10){
                if(isCanWalk()){
                    Walk();
                    Attack();
                }else {
                    AttackMorePower();
                }
            }
        }else{
            setAngry(false);
        }
        if(!isAngry()){
            spriteNum = 1;
        }
    }

    public void setHP(double HP) {
        if (getHP() > getMaxHP()){
            HP = getMaxHP();
        }
        this.HP = HP;
    }

    public void drawHp(GraphicsContext gc){
        double dot = getMaxHP()/32;
        int dots = (int)(getHP()/dot);
        for(int i=0;i<dots;i++){
            gc.drawImage(getHPB(),getX()+i,getY()-5);
        }
    }

    // getter setter for Monster
    public void setPlayer(Player player) {
        this.player = player;
    }
    public Image getHPB() {
        return HPB;
    }
    public void setHPB(Image HPB) {
        this.HPB = HPB;
    }
    public double getMaxHP() {
        return maxHP;
    }
    public void setMaxHP(double maxHP) {
        this.maxHP = maxHP;
    }
    public boolean isAngry() {
        return isAngry;
    }
    public void setAngry(boolean angry) {
        isAngry = angry;
    }
    public double getHP() {
        return HP;
    }
    public void setDamage(double damage) {
        this.damage = damage;
    }
    public double getDamage() {
        return damage;
    }
    public boolean isCanWalk() {
        return canWalk;
    }
    public void setCanWalk(boolean canWalk) {
        this.canWalk = canWalk;
    }
}
