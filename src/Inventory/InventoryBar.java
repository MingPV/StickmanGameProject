package Inventory;

import Item.BaseForItem;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import main.KeyHandler;

import java.util.ArrayList;

public class InventoryBar {

    private ArrayList<ArrayList<BaseForItem>> items = new ArrayList<ArrayList<BaseForItem>>();

    private Image InventoryB = new Image("file:res/player/InventoryB.png");
    private Image SelectedSlot = new Image("file:res/player/SelectedSlot.png");
    private int selectedslot = 0;
    private boolean pressed = false;
    private int spriteCounter;
    private int spriteNum;


    public void draw(GraphicsContext gc){
        gc.drawImage(InventoryB,0,500);
        gc.drawImage(SelectedSlot,selectedslot*60,500);
    }

    public void update(){
        if(!pressed){
            if(KeyHandler.getKeyPressed(KeyCode.E)){
                setSelectedslot(getSelectedslot()+1);
                pressed = true;
            }else if(KeyHandler.getKeyPressed(KeyCode.Q)){
                setSelectedslot(getSelectedslot()-1);
                pressed = true;
            }
        }else{
            if(!(KeyHandler.getKeyPressed(KeyCode.E)||KeyHandler.getKeyPressed(KeyCode.Q))){
                pressed = false;
            }
        }

    }
    public void setSelectedslot(int selectedslot) {
        if(selectedslot>9){
            selectedslot = selectedslot%10;
        }
        if(selectedslot<0){
            selectedslot += 10;
        }
        this.selectedslot = selectedslot;
    }

    public int getSelectedslot() {
        return this.selectedslot;
    }

    public ArrayList<ArrayList<BaseForItem>> getItems() {
        return items;
    }

}
