package Item;

import com.sun.jdi.Value;
import entity.Monster;
import entity.Player;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import static main.GamePanel.itemOnFloors;

public class BaseItem extends BaseForItem {

    public BaseItem(Monster monster,Player player){
        setDefalutValues(monster,player);
    }

    public void setDefalutValues(Monster monster,Player player){

        setPlayer(player);
        setX(monster.getX());
        setY(monster.getY());
        setSlot(-1);
        setAdded(false);
        setPicked(false);
        setUsed(false);
        setPrepareDelete(0);
        setWink(false);
        setDeleteCounter(0);
        setItemImageURL("item/RedPotion.png");
        setItemImage(new Image(String.valueOf(ClassLoader.getSystemResource(getItemImageURL()))));
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
