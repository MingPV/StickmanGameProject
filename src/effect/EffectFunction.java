package effect;

import javafx.scene.canvas.GraphicsContext;

public interface EffectFunction {

    void draw(GraphicsContext gc);
    boolean isDestroyed();
    boolean isVisible();


}