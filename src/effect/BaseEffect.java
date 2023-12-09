package effect;

import entity.Monster;
import entity.Player;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import static main.GamePanel.Effects;

public class BaseEffect extends Effect {

    public BaseEffect(Player player){
        setDefalutValues(player);
    }
    public BaseEffect(Monster monster){
        setDefalutValues(monster);
    }


    public BaseEffect(Monster monster, Player player){
        setDefalutValues(monster,player);
    }

    public void setDefalutValues(Monster monster){

        setMonster(monster);
        setX(monster.getX());
        setY(monster.getY());
        setOwner("monster");
        setEffectClass(BaseEffect.class);
        loadpic();

        setSpriteNum(1);
        setSpriteCounter(0);

    }

    public void setDefalutValues(Player player){

        setPlayer(player);
        setOwner("player");
        setX(player.getX());
        setY(player.getY());
        setEffectClass(BaseEffect.class);
        loadpic();

        setSpriteNum(1);
        setSpriteCounter(0);

    }

    public void setDefalutValues(Monster monster,Player player){

        setPlayer(player);
        setX(monster.getX());
        setY(monster.getY());
        setEffectClass(BaseEffect.class);
        loadpic();

        setSpriteNum(1);
        setSpriteCounter(0);

    }

    public void loadpic(){

        setEffect1(new Image("file:res/effect/spawn_1.png"));
        setEffect1(new Image("file:res/effect/spawn_2.png"));


    }

    public void updateAll(Player player){
        if(!Effects.isEmpty()){
            for(int i=0;i<Effects.size();i++){
                switch (String.valueOf(Effects.get(i).getClass())){
                    case "class effect.diedEffect" :
                        ((diedEffect) Effects.get(i)).update();
                        break;
                    case "class effect.spawnEffect" :
                        ((spawnEffect) Effects.get(i)).update();
                        break;
                    case "class effect.ShadowEffect" :
                        ((ShadowEffect) Effects.get(i)).update();
                        break;
                        // can add more Effect class

                }
            }
        }
    }
    public void drawAll(GraphicsContext gc){
        if(!Effects.isEmpty()){
            for(int i=0;i<Effects.size();i++){
                switch (String.valueOf(Effects.get(i).getClass())){
                    case "class effect.diedEffect" :
                        ((diedEffect) Effects.get(i)).draw(gc);
                        break;
                    case "class effect.spawnEffect" :
                        ((spawnEffect) Effects.get(i)).draw(gc);
                        break;
                    case "class effect.ShadowEffect" :
                        ((ShadowEffect) Effects.get(i)).draw(gc);
                        break;
                        // can add more Effect class
                }
            }
        }
    }

}
