package entity;

import effect.ShadowEffect;
import javafx.scene.image.Image;

public abstract class Prop {

    private double x, y;

    private Image PropImage;

    public int spriteCounter = 0;
    public int spriteNum = 1;

    private ShadowEffect shadowEffect;

    private Object PropClass;

    public ShadowEffect getShadowEffect() {
        return shadowEffect;
    }

    public Object getPropClass() {
        return PropClass;
    }

    public Image getPropImage() {
        return PropImage;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setShadowEffect(ShadowEffect shadowEffect) {
        this.shadowEffect = shadowEffect;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setPropClass(Object propClass) {
        PropClass = propClass;
    }

    public void setPropImage(Image propImage) {
        PropImage = propImage;
    }
}
