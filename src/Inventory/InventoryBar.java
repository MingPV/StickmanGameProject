package Inventory;

import Item.BaseItem;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class InventoryBar {

    private ArrayList<BaseItem> items = new ArrayList<BaseItem>();

    private Image InventoryB = new Image("file:res/player/InventoryB.png");

    public void draw(GraphicsContext gc){
        gc.drawImage(InventoryB,0,500);
    }


}
