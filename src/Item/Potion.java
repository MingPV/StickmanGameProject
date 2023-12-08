package Item;

import entity.Monster;
import entity.Player;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import static main.GamePanel.*;

public class Potion extends BaseItem implements BaseFunction{

    public Potion(Monster monster){
        super(monster);
        setItemImage(new Image("file:res/item/RedPotion.png"));
    }

    @Override
    public void use(Player player) {
        player.setExp(player.getExp()+10);
        delete(player);
    }

    @Override
    public void update(Player player) {

        if(spriteNum == 1){
            setX(getX()-0.4);
            setY(getY()-0.6);
        }else if (spriteNum == 2){
            setX(getX()-0.2);
            setY(getY()+0.8);
        }


        spriteCounter++;
        if(spriteCounter == 10) {
            spriteNum = 2;
        }else if(spriteCounter == 20){
            spriteNum = 3;    // not use value
        }

    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(getItemImage(),getX(),getY());
    }

    @Override
    public void additem(Player player) {
        boolean found = false;
        for(int i=0;i<10;i++){
            if(!player.getInventoryBar().getItems().get(i).isEmpty()){
                if(player.getInventoryBar().getItems().get(i).get(0).getClass() == Potion.class){
                    player.getInventoryBar().getItems().get(i).add(this);
                    found = true;
                    setAdded(true);
                    return;
                }
            }
        }
        if(!found){
            for(int i=0;i<10;i++){
                if(player.getInventoryBar().getItems().get(i).isEmpty()){
                    player.getInventoryBar().getItems().get(i).add(this);
                    setAdded(true);
                }
            }
        }
    }


    @Override
    public void delete(Player player) {
        for(int i=0;i<10;i++){
            if(!player.getInventoryBar().getItems().get(i).isEmpty()){
                if(player.getInventoryBar().getItems().get(i).get(0).getClass() == Potion.class){
                    player.getInventoryBar().getItems().get(i).remove(player.getInventoryBar().getItems().get(i).size()-1);
                    return;
                }
            }
        }
    }


}
