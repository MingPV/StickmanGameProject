package tile;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;


public class Background extends Tile implements TileFunction {

    private Image Background = new Image("file:res/background/BackgroundG.png");
    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(Background,0,0);
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
