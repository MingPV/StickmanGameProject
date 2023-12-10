package entity;

import effect.ShadowEffect;
import javafx.scene.image.Image;


public abstract class Entity {

    private double x, y;
    private double speed;

    //public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    private Image up1, up2, down1, down2, left1, left2, right1, right2,up3,down3,left3,right3;

    private Image currentImage;
    private String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;

    private boolean isAttack;

    private ShadowEffect shadowEffect;

    private Object EntityClass;

    private boolean CanWalkUP;
    private boolean canWalkLeft;
    private boolean canWalkDown;
    private boolean canWalkRight;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getSpeed() {
        return speed;
    }

    public int getSpriteCounter() {
        return spriteCounter;
    }

    public int getSpriteNum() {
        return spriteNum;
    }

    public String getDirection() {
        return direction;
    }

    public void setX(double x) {
        if(x<0){
            x=0;
        }
        if(x>800){
            x=800;
        }
        this.x = x;
    }

    public void setY(double y) {
        if(y<0){
            y=0;
        }
        if(y>600){
            y=600;
        }
        this.y = y;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setSpriteNum(int spriteNum) {
        this.spriteNum = spriteNum;
    }

    public void setSpriteCounter(int spriteCounter) {
        this.spriteCounter = spriteCounter;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Image getUp1() {
        return up1;
    }

    public Image getUp2() {
        return up2;
    }

    public Image getDown1() {
        return down1;
    }

    public Image getDown2() {
        return down2;
    }

    public Image getLeft1() {
        return left1;
    }

    public Image getLeft2() {
        return left2;
    }

    public Image getRight1() {
        return right1;
    }

    public Image getRight2() {
        return right2;
    }

    public void setDown1(Image down1) {
        this.down1 = down1;
    }

    public void setDown2(Image down2) {
        this.down2 = down2;
    }

    public void setLeft1(Image left1) {
        this.left1 = left1;
    }

    public void setLeft2(Image left2) {
        this.left2 = left2;
    }

    public void setRight1(Image right1) {
        this.right1 = right1;
    }

    public void setRight2(Image right2) {
        this.right2 = right2;
    }

    public void setUp1(Image up1) {
        this.up1 = up1;
    }

    public void setUp2(Image up2) {
        this.up2 = up2;
    }

    public Image getCurrentImage() {
        return currentImage;
    }

    public void setCurrentImage(Image currentImage) {
        this.currentImage = currentImage;
    }

    public void setDown3(Image down3) {
        this.down3 = down3;
    }

    public void setLeft3(Image left3) {
        this.left3 = left3;
    }

    public void setRight3(Image right3) {
        this.right3 = right3;
    }

    public void setUp3(Image up3) {
        this.up3 = up3;
    }

    public Image getDown3() {
        return down3;
    }

    public Image getLeft3() {
        return left3;
    }

    public Image getRight3() {
        return right3;
    }

    public Image getUp3() {
        return up3;
    }

    public boolean isAttack() {
        return isAttack;
    }

    public void setAttack(boolean attack) {
        isAttack = attack;
    }

    public ShadowEffect getShadowEffect() {
        return shadowEffect;
    }

    public void setShadowEffect(ShadowEffect shadowEffect) {
        this.shadowEffect = shadowEffect;
    }

    public void setEntityClass(Object entityClass) {
        EntityClass = entityClass;
    }

    public Object getEntityClass() {
        return EntityClass;
    }

    public void setCanWalkDown(boolean canWalkDown) {
        this.canWalkDown = canWalkDown;
    }

    public void setCanWalkLeft(boolean canWalkLeft) {
        this.canWalkLeft = canWalkLeft;
    }

    public void setCanWalkRight(boolean canWalkRight) {
        this.canWalkRight = canWalkRight;
    }

    public void setCanWalkUp(boolean canWalkUP) {
        CanWalkUP = canWalkUP;
    }

    public boolean isCanWalkDown() {
        return canWalkDown;
    }

    public boolean isCanWalkLeft() {
        return canWalkLeft;
    }

    public boolean isCanWalkRight() {
        return canWalkRight;
    }

    public boolean isCanWalkUP() {
        return CanWalkUP;
    }
}
