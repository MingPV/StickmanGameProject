package Inventory;

import Item.BaseItem;
import Item.Potion;
import entity.Player;
import font.Number;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import main.GamePanel;
import main.KeyHandler;

import java.util.ArrayList;


public class InventoryBar {

    private ArrayList<ArrayList<BaseItem>> items;

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

        setItems(new ArrayList<ArrayList<BaseItem>>());
        for(int i=0;i<10;i++){
            getItems().add(new ArrayList<BaseItem>());
        }
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
                if(!getItems().get(getSelectedSlot()).isEmpty()){
                    BaseItem itemA = getItems().get(getSelectedSlot()).get(0);
                    if(itemA.getClass() == Potion.class){
                        ((Potion) itemA).use(player);
                    }

                    // add more item class use switch case



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
        for(int i=0;i<10;i++){
            if(!items.get(i).isEmpty()){
                items.get(i).get(0).updateAll(player);
            }
        }
    }
    public void drawItemInInventory(GraphicsContext gc){
        for(int i=0;i<10;i++){
            if(!items.get(i).isEmpty()){
                for(int j=0;i<items.get(i).size();i++){
                    gc.drawImage(items.get(i).get(j).getItemImage(),120+i*60,543);
                    if(GamePanel.number != null){
                        int amount = items.get(i).size();
                        gc.drawImage(GamePanel.number.getNumberImage(amount), 137+i*60,550);

                    }
                }
            }
        }
    }


    public ArrayList<ArrayList<BaseItem>> getItems() {
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

    public void setItems(ArrayList<ArrayList<BaseItem>> items) {
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
