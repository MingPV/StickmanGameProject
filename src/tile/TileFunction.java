package tile;

import javafx.scene.canvas.GraphicsContext;

public interface TileFunction {
    void draw(GraphicsContext gc);
    boolean isDestroyed();
    boolean isVisible();
}
