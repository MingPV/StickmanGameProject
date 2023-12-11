package effect;

import entity.Monster;
import entity.Player;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import static main.GamePanel.Effects;

public class BaseEffect extends Effect {

    public BaseEffect(Player player) {
        setDefaultValues(player);
    }

    public BaseEffect(Monster monster) {
        setDefaultValues(monster);
    }


    public BaseEffect(Monster monster, Player player) {
        setDefaultValues(monster, player);
    }

    public void setDefaultValues(Monster monster) {

        setMonster(monster);
        setX(monster.getX());
        setY(monster.getY());
        setOwner("monster");
        setEffectClass(BaseEffect.class);
        loadPicture();

        setSpriteNum(1);
        setSpriteCounter(0);

    }

    public void setDefaultValues(Player player) {

        setPlayer(player);
        setOwner("player");
        setX(player.getX());
        setY(player.getY());
        setEffectClass(BaseEffect.class);
        loadPicture();

        setSpriteNum(1);
        setSpriteCounter(0);

    }

    public void setDefaultValues(Monster monster, Player player) {

        setPlayer(player);
        setX(monster.getX());
        setY(monster.getY());
        setEffectClass(BaseEffect.class);
        loadPicture();

        setSpriteNum(1);
        setSpriteCounter(0);

    }

    public void loadPicture() {

        //default image
        setEffect1(new Image(String.valueOf(ClassLoader.getSystemResource("effect/spawn_1.png"))));
        setEffect1(new Image(String.valueOf(ClassLoader.getSystemResource("effect/spawn_2.png"))));

    }

    public void updateAll(Player player){
        if(!Effects.isEmpty()){
            for(int i=0;i<Effects.size();i++){
                switch (String.valueOf(Effects.get(i).getClass())){
                    case "class effect.DiedEffect" :
                        ((DiedEffect) Effects.get(i)).update();
                        break;
                    case "class effect.SpawnEffect" :
                        ((SpawnEffect) Effects.get(i)).update();
                        break;
                    case "class effect.ShadowEffect" :
                        ((ShadowEffect) Effects.get(i)).update();
                        break;
                    case "class effect.SuperSaiyan" :
                        ((SuperSaiyan) Effects.get(i)).update();
                        // can add more Effect class

                }
            }
        }
    }
    public void drawAll(GraphicsContext gc){
        if(!Effects.isEmpty()){
            for(int i=0;i<Effects.size();i++){
                switch (String.valueOf(Effects.get(i).getClass())){
                    case "class effect.DiedEffect" :
                        ((DiedEffect) Effects.get(i)).draw(gc);
                        break;
                    case "class effect.SpawnEffect" :
                        ((SpawnEffect) Effects.get(i)).draw(gc);
                        break;
                    case "class effect.ShadowEffect" :
                        ((ShadowEffect) Effects.get(i)).draw(gc);
                        break;
                    case "class effect.SuperSaiyan" :
                        ((SuperSaiyan) Effects.get(i)).draw(gc);
                        // can add more Effect class
                }
            }
        }
    }


}
