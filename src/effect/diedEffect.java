package effect;

import entity.Monster;
import entity.Player;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Objects;

import static main.GamePanel.*;

public class diedEffect extends BaseEffect implements EffectFunction {


    Monster monster;

    int count = 0;


    public diedEffect(Monster monster,Player player){
        super(monster, player);
        setEffectClass(diedEffect.class);

    }

    public void loadpic(){
        setUp1(new Image("file:res/player/boy_up_1.png"));
        setUp2(new Image("file:res/player/boy_up_2.png"));
        setDown1(new Image("file:res/player/boy_down_1.png"));
        setDown2(new Image("file:res/player/boy_down_2.png"));
        // change died effect here

        setLeft1(new Image("file:res/player/boy_left_1.png"));
        setLeft2(new Image("file:res/player/boy_left_2.png"));
        setRight1(new Image("file:res/player/boy_right_1.png"));
        setRight2(new Image("file:res/player/boy_right_2.png"));

        setEffect1(new Image("file:res/effect/spawn_1.png"));
        setEffect2(new Image("file:res/effect/spawn_2.png"));
        //setEffect3();
        //setEffect4();

    }

    public void update(){
        // update

        spriteCounter++;
        if(spriteCounter > 5) {
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


        if(count < 3){
            setPhase("phaseA");
        }else if(count < 5){
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
                    setCurrentImage(getUp1());

                }
                if(spriteNum == 2) {
                    setCurrentImage(getUp2());

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
        return true;
    }



}
