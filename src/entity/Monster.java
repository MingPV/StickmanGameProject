package entity;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Objects;

import static main.GamePanel.monsters;

public class Monster extends Entity implements EntityFunction {

    Player player;

    private double HP;
    private double maxHP;
    private Image HPB;

    public Monster(){
        // just for calling updateAll and drawAll //
    }

    public Monster(Player player){

        setDefaultValues(player);

    }

    public void setDefaultValues(Player player) {

        setPlayer(player);

        setX(Math.floor(Math.random() *(800)));
        setY(Math.floor(Math.random() *(600)));
        setSpeed(0.3);
        setMaxHP(100);
        setHP(100);
        setDirection("down");
        loadpic();

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

        setHPB(new Image("file:res/player/hpdemored.png"));

    }

    public void update(Player player){
        // update

        setPlayer(player);

        if(getHP() <= 0){
            delete();
        }

        if (player.getY()<getY()){
            setY(getY()-getSpeed());
            setDirection("up");
        }
        if (player.getX()<getX()){
            setX(getX()-getSpeed());
            setDirection("left");
        }
        if (player.getY()>getY()){
            setY(getY()+getSpeed());
            setDirection("down");
        }
        if (player.getX()>getX()){
            setX(getX()+getSpeed());
            setDirection("right");
        }
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

        System.out.println(getHP());

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

    }

    public void delete(){
        monsters.add(new Monster(player));
        monsters.add(new Monster(player));
        monsters.remove(this);
    }

    public void updateAll(ArrayList<Monster> monsters){
        if(!monsters.isEmpty()){
            for (int i=0;i<monsters.size();i++) {
                monsters.get(i).update(player);
            }
        }
    }

    public void drawAll(ArrayList<Monster> monsters, GraphicsContext gc){
        if(!monsters.isEmpty()){
            for (Monster monster : monsters) {
                monster.draw(gc);
            }
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

    public double getHP() {
        return HP;
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
            gc.drawImage(getHPB(),getX()-6+i,getY()-5);
        }
    }
}
