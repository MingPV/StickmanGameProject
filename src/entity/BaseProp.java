package entity;

import Item.BluePotion;
import Item.CoffeePotion;
import Item.Potion;
import Item.RedPotion;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import static main.GamePanel.Props;
import static main.GamePanel.itemOnFloors;

public class BaseProp extends Prop{

    public BaseProp(int x,int y){

        setDefaultValues(x,y);

    }

    public void setDefaultValues(int x, int y){

        setPropClass(BaseProp.class);
        setX(x);
        setY(y);
        setPropImage(new Image(String.valueOf(ClassLoader.getSystemResource("prop/ChristmasTree.png"))));

    }

    public void updateAll(){
        if(!Props.isEmpty()){
            for(int i=0;i<Props.size();i++){
                switch (String.valueOf(Props.get(i).getClass())){
                    case "class entity.ChristmasTree" :
                        ((ChristmasTree) Props.get(i)).update();
                        break;
                    case "class entity.Gift" :
                        ((Gift) Props.get(i)).update();
                        break;
                    case "class entity.Gift2" :
                        ((Gift2) Props.get(i)).update();
                        break;
                    case "class entity.Snowman" :
                        ((Snowman) Props.get(i)).update();
                        break;
                }
            }
        }
    }
    public void drawAll(GraphicsContext gc){
        if(!Props.isEmpty()){
            for(int i=0;i<Props.size();i++){
                switch (String.valueOf(Props.get(i).getClass())){
                    case "class entity.ChristmasTree" :
                        ((ChristmasTree) Props.get(i)).draw(gc);
                        break;
                    case "class entity.Gift" :
                        ((Gift) Props.get(i)).draw(gc);
                        break;
                    case "class entity.Gift2" :
                        ((Gift2) Props.get(i)).draw(gc);
                        break;
                    case "class entity.Snowman" :
                        ((Snowman) Props.get(i)).draw(gc);
                        break;
                }
            }
        }
    }


}
