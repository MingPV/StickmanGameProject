package Item;

import javafx.scene.image.Image;

public abstract class BaseForItem {

    private Image itemImage;
    private double x;
    private double y;
    private int amount;
    private boolean isAdded;
    private boolean isUsed;
    private boolean isPicked;
    public int spriteCounter;
    public int spriteNum;


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Image getItemImage() {
        return itemImage;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setItemImage(Image itemImage) {
        this.itemImage = itemImage;
    }

    public void setAdded(boolean added) {
        isAdded = added;
    }

    public boolean isAdded() {
        return isAdded;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }

    public void setPicked(boolean picked) {
        isPicked = picked;
    }

    public boolean isPicked() {
        return isPicked;
    }

    public void setSpriteCounter(int spriteCounter) {
        this.spriteCounter = spriteCounter;
    }

    public void setSpriteNum(int spriteNum) {
        this.spriteNum = spriteNum;
    }


}
