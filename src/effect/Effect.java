package effect;

import entity.Monster;
import entity.Player;
import javafx.scene.image.Image;

public abstract class Effect {

    private double x, y;
    private double speed;

    Monster monster;
    Player player;

    private String owner;

    //public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    private Image up1, up2, down1, down2, left1, left2, right1, right2;
    private Image spawn1,spawn2;
    private Image effect1,effect2,effect3,effect4;

    private Image currentImage;
    private String phase;

    public int spriteCounter = 0;
    public int spriteNum = 1;

    private Object effectClass;



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

    public String getPhase() {
        return phase;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
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

    public void setPhase(String phase) {
        this.phase = phase;
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

    public Image getSpawn1() {
        return spawn1;
    }

    public Image getSpawn2() {
        return spawn2;
    }

    public void setSpawn1(Image spawn1) {
        this.spawn1 = spawn1;
    }

    public void setSpawn2(Image spawn2) {
        this.spawn2 = spawn2;
    }

    public Image getCurrentImage() {
        return currentImage;
    }

    public void setCurrentImage(Image currentImage) {
        this.currentImage = currentImage;
    }

    public Player getPlayer() {
        return player;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public void setEffectClass(Object effectClass) {
        this.effectClass = effectClass;
    }

    public Object getEffectClass() {
        return effectClass;
    }

    public Image getEffect1() {
        return effect1;
    }

    public Image getEffect2() {
        return effect2;
    }

    public Image getEffect3() {
        return effect3;
    }

    public Image getEffect4() {
        return effect4;
    }

    public void setEffect1(Image effect1) {
        this.effect1 = effect1;
    }

    public void setEffect2(Image effect2) {
        this.effect2 = effect2;
    }

    public void setEffect3(Image effect3) {
        this.effect3 = effect3;
    }

    public void setEffect4(Image effect4) {
        this.effect4 = effect4;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
