package Item;

import entity.Player;
import javafx.scene.image.Image;

public abstract class BaseForItem {

    private Player player;
    private Image itemImage;
    private String itemImageURL;
    private double x;
    private double y;
    private int slot;
    private int amount;
    private boolean isAdded;
    private boolean isUsed;
    private boolean isPicked;
    public int spriteCounter;
    public int spriteNum;

    private int deleteCounter;
    private boolean isWink;

    private int prepareDelete;

    private Object itemClass;

    private int dropDirection;
    private int dropRange;



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

    public void setItemImageURL(String itemImageURL) {
        this.itemImageURL = itemImageURL;
    }

    public String getItemImageURL() {
        return itemImageURL;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public int getSlot() {
        return slot;
    }

    public int getPrepareDelete() {
        return prepareDelete;
    }

    public void setPrepareDelete(int prepareDelete) {
        this.prepareDelete = prepareDelete;
    }

    public void setDeleteCounter(int deleteCounter) {
        this.deleteCounter = deleteCounter;
    }

    public int getDeleteCounter() {
        return deleteCounter;
    }

    public boolean isWink() {
        return isWink;
    }

    public void setWink(boolean wink) {
        isWink = wink;
    }

    public void setItemClass(Object itemClass) {
        this.itemClass = itemClass;
    }

    public Object getItemClass() {
        return itemClass;
    }

    public int getDropDirection() {
        return dropDirection;
    }

    public void setDropDirection(int dropDirection) {
        this.dropDirection = dropDirection;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setDropRange(int dropRange) {
        this.dropRange = dropRange;
    }

    public int getDropRange() {
        return dropRange;
    }
}
