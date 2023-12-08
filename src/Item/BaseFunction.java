package Item;

import entity.Player;
import javafx.scene.canvas.GraphicsContext;

public interface BaseFunction {

    void use(Player player);
    void update(Player player);
    void draw(GraphicsContext gc);
    void additem(Player player);
    void delete(Player player);

}
