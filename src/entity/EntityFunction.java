package entity;

import javafx.scene.canvas.GraphicsContext;

public interface EntityFunction {
    void draw(GraphicsContext gc);
    boolean isDestroyed();
    boolean isVisible();

}
