package tile;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class Background extends Tile implements TileFunction {
    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.BLACK);
        gc.fillRect(0,0,800, 600);
    }

    @Override
    public boolean isDestroyed() {
        return false;
    }

    @Override
    public boolean isVisible() {
        return true;
    }
}
