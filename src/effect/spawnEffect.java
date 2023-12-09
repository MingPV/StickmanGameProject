package effect;

import entity.Monster;
import entity.Player;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Objects;

import static main.GamePanel.Effects;

public class spawnEffect extends BaseEffect implements EffectFunction {


    Player player;
    Monster monster;

    int count = 0;

    public spawnEffect(Player player){

        super(player);
        setEffectClass(spawnEffect.class);
        // for spawn player

    }
    public spawnEffect(Monster monster){

        super(monster);
        setEffectClass(spawnEffect.class);
        // for spawn player

    }

    public spawnEffect(Player player, Monster monster){

        super(monster,player);
        setEffectClass(spawnEffect.class);

    }

    public void loadpic(){

        setEffect1(new Image("file:res/effect/spawn_1.png"));
        setEffect2(new Image("file:res/effect/spawn_2.png"));


    }

    public void update(){
        // update

        spriteCounter++;
        if(spriteCounter > 10) {
            if(spriteNum == 1) {
                spriteNum = 2;
                //System.out.println(spriteNum);
            }
            else if(spriteNum == 2) {
                spriteNum = 1;
                //System.out.println(spriteNum);
            }
            spriteCounter = 0;
            count++;
        }

        if(count < 1){
            setPhase("phaseA");
        }else if(count < 2){
            setPhase("phaseB");
        }else{
            setPhase("phaseDelete");
        }

        if(Objects.equals(getPhase(), "phaseB")){
            setY(getY()-5);
        }
        if(Objects.equals(getPhase(), "phaseDelete")){
            delete();
        }

    }



    @Override
    public void draw(GraphicsContext gc) {

        boolean delete = false;

        switch(getPhase()) {
            case "phaseA":
                if(spriteNum == 1) {
                    setCurrentImage(getEffect1());
                    //System.out.println(spriteNum);

                }
                if(spriteNum == 2) {
                    setCurrentImage(getEffect2());
                    //System.out.println(spriteNum);

                }
                break;
            case "phaseB":
                if(spriteNum == 1) {
                    setCurrentImage(getEffect1());

                }
                if(spriteNum == 2) {
                    setCurrentImage(getEffect2());

                }
                break;
            case "phaseDelete":
                delete = true;
                break;

        }

        if(!delete){
            gc.drawImage(getCurrentImage(),getX(),getY());
        }

    }

    public void delete(){
        Effects.remove(this);
    }

    @Override
    public boolean isDestroyed() {
        return false;
    }

    @Override
    public boolean isVisible() {
        return false;
    }
}
