package Inventory;

import Item.BaseItem;
import Item.BluePotion;
import Item.Potion;
import Item.RedPotion;
import entity.Player;
import font.Number;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import main.GamePanel;
import main.KeyHandler;

import java.util.ArrayList;

import static main.GamePanel.itemOnFloors;


public class InventoryBar {

    private ArrayList<BaseItem> items;

    private Player player;

    private Image InventoryB;
    private Image SelectedSlotImage;
    public static int selectedSlot;
    private boolean pressed;
    private int spriteCounter;
    private int spriteNum;
    private String ImageURL;
    private String SelectedImageURL;

    public InventoryBar(){
        setDefaultValues();
    }

    public void setDefaultValues(){

        setImageURL("player/InventoryB.png");
        setSelectedImageURL("player/SelectedSlot.png");


        setInventoryB(new Image(String.valueOf(ClassLoader.getSystemResource(getImageURL()))));
        setSelectedSlotImage(new Image(getSelectedImageURL()));
        setSelectedSlot(0);
        setPressed(false);
        setPlayer(player);

        setItems(new ArrayList<BaseItem>());

    }


    public void draw(GraphicsContext gc){
        gc.drawImage(InventoryB,0,500);
        gc.drawImage(SelectedSlotImage, selectedSlot *60,500);
        drawItemInInventory(gc);

    }

    public void update(Player player){
        setPlayer(player);
        if(!pressed){
            if(KeyHandler.getKeyPressed(KeyCode.E)){
                setSelectedSlot(getSelectedSlot()+1);
                pressed = true;
            }else if(KeyHandler.getKeyPressed(KeyCode.Q)){
                setSelectedSlot(getSelectedSlot()-1);
                pressed = true;
            }else if(KeyHandler.getKeyPressed(KeyCode.J)){
                if(getSelectedSlot() < getItems().size()){
                    BaseItem itemA = getItems().get(getSelectedSlot());

                    // add more item class use switch case here

                    switch (String.valueOf(itemA.getClass())) {
                        case "class Item.Potion":
                            ((Potion) itemA).use(player);
                            break;
                        case "class Item.BluePotion":
                            ((BluePotion) itemA).use(player);
                            break;
                        case "class Item.RedPotion":
                            ((RedPotion) itemA).use(player);
                            break;
                    }
                }
                pressed = true;
            }
        }else{
            if(!(KeyHandler.getKeyPressed(KeyCode.E)||KeyHandler.getKeyPressed(KeyCode.Q)||KeyHandler.getKeyPressed(KeyCode.J))){
                pressed = false;
            }
        }

        updateInventory();

    }

    public void updateInventory(){

            if (!items.isEmpty()) {
                for (int i = 0; i < items.size(); i++) {
                    switch (String.valueOf(items.get(i).getClass())) {
                        case "class Item.Potion":
                            ((Potion) items.get(i)).update(player);
                            break;
                        case "class Item.BluePotion":
                            ((BluePotion) items.get(i)).update(player);
                            break;
                        case "class Item.RedPotion":
                            ((RedPotion) items.get(i)).update(player);
                            break;
                    }
                }
            }
    }
    public void drawItemInInventory(GraphicsContext gc){
        if(!items.isEmpty()){
            for(int i=0;i<items.size();i++){
                System.out.println(items.get(i));
                gc.drawImage(items.get(i).getItemImage(),120+i*60,543);
                if(GamePanel.number != null){
                    gc.drawImage(GamePanel.number.getNumberImage(items.get(i).getAmount()),137+i*60,550 );
                }
            }
        }
    }


    public ArrayList<BaseItem> getItems() {
        return items;
    }

    public Image getInventoryB() {
        return InventoryB;
    }

    public int getSelectedSlot() {
        return selectedSlot;
    }

    public void setSelectedSlotImage(Image selectedSlotImage) {
        SelectedSlotImage = selectedSlotImage;
    }

    public void setSelectedSlot(int selectedSlot) {
        if(selectedSlot >9){
            selectedSlot = selectedSlot %10;
        }
        if(selectedSlot <0){
            selectedSlot += 10;
        }
        this.selectedSlot = selectedSlot;
    }

    public void setInventoryB(Image inventoryB) {
        InventoryB = inventoryB;
    }

    public void setItems(ArrayList<BaseItem> items) {
        this.items = items;
    }

    public void setPressed(boolean pressed) {
        this.pressed = pressed;
    }

    public Image getSelectedSlotImage() {
        return SelectedSlotImage;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getImageURL() {
        return ImageURL;
    }

    public void setImageURL(String imageURL) {
        ImageURL = imageURL;
    }

    public String getSelectedImageURL() {
        return SelectedImageURL;
    }

    public void setSelectedImageURL(String selectedImageURL) {
        SelectedImageURL = selectedImageURL;
    }
}
