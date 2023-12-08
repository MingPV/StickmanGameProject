package Item;

import entity.Monster;
import entity.Player;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import static main.GamePanel.itemOnFloors;

public class BaseItem extends BaseForItem {

    public BaseItem(Monster monster){
        setDefalutValues(monster);
    }

    public void setDefalutValues(Monster monster){
        setX(monster.getX());
        setY(monster.getY());
        setAdded(false);
        setPicked(false);
        setUsed(false);
        setItemImage(new Image("file:res/item/RedPotion.png"));
        setSpriteNum(1);
        setSpriteCounter(0);
    }
    public void updateAll(Player player){
        if(!itemOnFloors.isEmpty()){
            for(int i=0;i<itemOnFloors.size();i++){
                if(itemOnFloors.get(i).getClass() == Potion.class){
                    ((Potion) itemOnFloors.get(i)).update(player);
                }
            }
        }
    }
    public void drawAll(GraphicsContext gc){
        if(!itemOnFloors.isEmpty()){
            for(int i=0;i<itemOnFloors.size();i++){
                if(itemOnFloors.get(i).getClass() == Potion.class){
                    ((Potion) itemOnFloors.get(i)).draw(gc);
                }
            }
        }
    }

}
