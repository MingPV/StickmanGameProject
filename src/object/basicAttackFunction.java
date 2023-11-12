package object;

import javafx.scene.canvas.GraphicsContext;

public interface basicAttackFunction {
    void draw(GraphicsContext gc);
    boolean isDestroyed();
    boolean isVisible();


}
