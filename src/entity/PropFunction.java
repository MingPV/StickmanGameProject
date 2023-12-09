package entity;

import javafx.scene.canvas.GraphicsContext;

public interface PropFunction {

    void draw(GraphicsContext gc);
    boolean isDestroyed();
    boolean isVisible();

}
