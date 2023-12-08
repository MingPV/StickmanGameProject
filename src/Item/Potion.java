package Item;

import entity.Monster;
import entity.Player;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import static java.lang.Math.pow;
import static main.GamePanel.*;

public class Potion extends BaseItem implements BaseFunction{

    public Potion(Monster monster, Player player){
        super(monster,player);
        setItemImage(new Image("file:res/item/RedPotion.png"));
    }

    @Override
    public void use(Player player) {
        if(player != null){
            player.setExp(player.getExp()+10);
            deleteItem(player);
            System.out.println("Deleteeeeeeeeeeeeeeeeeeeeeeeeeeeee");
        }
    }

    @Override
    public void update(Player player) {

        if(spriteNum == 1){
            setX(getX()-0.4);
            setY(getY()-0.6);
        }else if (spriteNum == 2){
            setX(getX()-0.2);
            setY(getY()+0.8);
        }else if(spriteNum == 3){
            if(player != null){
                if(pow(player.getX()-getX(),2) <= 25 && pow(player.getY()-getY(),2) <= 25 ){
                    additem(player);
                }
            }

        }


        spriteCounter++;
        if(spriteCounter == 10) {
            spriteNum = 2;
        }else if(spriteCounter == 20){
            spriteNum = 3;    // not use value
        }



        if(getPrepareDelete() == 1){
            setDeleteCounter(getDeleteCounter()+1);
            if(getDeleteCounter() == 30){
                setWink(true);
            }
            if(getDeleteCounter() == 60){
                setWink(false);
                setDeleteCounter(0);
            }
        }

        autoDelete();

    }

    @Override
    public void draw(GraphicsContext gc) {
        if(!isPicked() && !isWink()){
            gc.drawImage(getItemImage(),getX(),getY());
        }
    }

    @Override
    public void additem(Player player) {
        boolean found = false;
        for(int i=0;i<10;i++){
            if(!player.getInventoryBar().getItems().get(i).isEmpty()){
                if(player.getInventoryBar().getItems().get(i).get(0).getClass() == Potion.class){
                    if(!isAdded() && player.getInventoryBar().getItems().get(i).size() < 9){
                        player.getInventoryBar().getItems().get(i).add(this);
                    }
                    found = true;
                    setSlot(i);
                    setAdded(true);
                    setPicked(true);
                    return;
                }
            }
        }
        if(!found){
            for(int i=0;i<10;i++){
                if(player.getInventoryBar().getItems().get(i).isEmpty()){
                    if(!isAdded() && player.getInventoryBar().getItems().get(i).size() < 9){
                        player.getInventoryBar().getItems().get(i).add(this);
                    }
                    setSlot(i);
                    setAdded(true);
                    setPicked(true);
                }
            }
        }
    }


    @Override
    public void deleteItem(Player player) {
        for(int i=0;i<10;i++){
            if(!player.getInventoryBar().getItems().get(i).isEmpty()){
                if(player.getInventoryBar().getItems().get(i).get(0).getClass() == Potion.class){
                    player.getInventoryBar().getItems().get(i).remove(player.getInventoryBar().getItems().get(i).size()-1);
                    return;
                }
            }
        }
    }

    @Override
    public void autoDelete() {

        if(spriteCounter == 1200){
            setPrepareDelete(1);
        }

        if(spriteCounter > 1700){
            itemOnFloors.remove(this);
        }
    }



}
