package entity;

import effect.ShadowEffect;
import javafx.scene.image.Image;

public abstract class Prop {

    public int spriteCounter = 0;
    public int spriteNum = 1;
    private double x, y;
    private Image PropImage;
    private ShadowEffect shadowEffect;

    private Object PropClass;

    public ShadowEffect getShadowEffect() {
        return shadowEffect;
    }

    public void setShadowEffect(ShadowEffect shadowEffect) {
        this.shadowEffect = shadowEffect;
    }

    public Object getPropClass() {
        return PropClass;
    }

    public void setPropClass(Object propClass) {
        PropClass = propClass;
    }

    public Image getPropImage() {
        return PropImage;
    }

    public void setPropImage(Image propImage) {
        PropImage = propImage;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
