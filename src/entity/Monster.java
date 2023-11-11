package entity;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import main.KeyHandler;


public class Monster extends Entity implements EntityFunction {

    Player player;

    private int HP;
    private int maxHP;
    private Image HPB;

    public Monster(Player player){

        setDefaultValues(player);

    }

    public void setDefaultValues(Player player) {

        setPlayer(player);

        setX(Math.floor(Math.random() *(800)));
        setY(Math.floor(Math.random() *(600)));
        setSpeed(0.3);
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

        setHPB(new Image("file:res/player/hpdemo2.png"));

    }

    public void update(Player player){
        // update

        setPlayer(player);

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

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        if (getHP() > getMaxHP()){
            HP = getMaxHP();
        }
        this.HP = HP;
    }
}
