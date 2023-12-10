package Background;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public class Background  {

    private final Image Background = new Image(String.valueOf(ClassLoader.getSystemResource("background/BackgroundG.png")));

    public void draw(GraphicsContext gc) {
        gc.drawImage(Background,0,0);
    }

}
