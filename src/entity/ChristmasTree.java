package entity;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class ChristmasTree extends BaseProp implements PropFunction{
    public ChristmasTree(int x, int y) {
        super(x, y);

        setPropClass(ChristmasTree.class);
        setPropImage(new Image("file:res/prop/ChristmasTree.png"));

    }

    public void update(){
        // if you want to update something
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(getPropImage(),getX(),getY());

    }

    @Override
    public boolean isDestroyed() {
        return false;
    }

    @Override
    public boolean isVisible() {
        return false;
    }
}
