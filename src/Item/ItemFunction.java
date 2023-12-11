package Item;

import entity.Player;
import javafx.scene.canvas.GraphicsContext;

public interface ItemFunction {

    void use(Player player);

    void update(Player player);

    void draw(GraphicsContext gc);

    void additem(Player player);

    void deleteItem(Player player);

    void autoDelete();


}
