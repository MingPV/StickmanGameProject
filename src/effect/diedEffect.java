package effect;

import entity.Monster;
import entity.Player;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Objects;

import static main.GamePanel.diedEffects;
import static main.GamePanel.monsters;

public class diedEffect extends Effect implements EffectFunction {


    Monster monster;

    int count = 0;

    public diedEffect(){
        // just for calling updateAll and drawAll //
    }

    public diedEffect(Monster monster){

        setDefaultValues(monster);

    }

    public void setDefaultValues(Monster monster) {

        setMonster(monster);

        setX(monster.getX());
        setY(monster.getY()-10);
        setPhase("phaseA");
        loadpic();

    }

    public void loadpic(){
        setUp1(new Image("file:res/player/boy_up_1.png"));
        setUp2(new Image("file:res/player/boy_up_2.png"));
        setDown1(new Image("file:res/player/boy_down_1.png"));
        setDown2(new Image("file:res/player/boy_down_2.png"));
        setLeft1(new Image("file:res/player/boy_left_1.png"));
        setLeft2(new Image("file:res/player/boy_left_2.png"));
        setRight1(new Image("file:res/player/boy_right_1.png"));
        setRight2(new Image("file:res/player/boy_right_2.png"));


    }

    public void update(){
        // update

        spriteCounter++;
        if(spriteCounter > 40) {
            if(spriteNum == 1) {
                spriteNum = 2;
                //System.out.println(spriteNum);
            }
            else if(spriteNum == 2) {
                spriteNum = 1;
                //System.out.println(spriteNum);
            }
            spriteCounter = 0;
        }

        count++;

        if(count < 10){
            setPhase("phaseA");
        }else if(count < 15){
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
                    setCurrentImage(getUp1());
                    //System.out.println(spriteNum);

                }
                if(spriteNum == 2) {
                    setCurrentImage(getUp2());
                    //System.out.println(spriteNum);

                }
                break;
            case "phaseB":
                if(spriteNum == 1) {
                    setCurrentImage(getDown1());

                }
                if(spriteNum == 2) {
                    setCurrentImage(getDown2());

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

        diedEffects.remove(this);
    }

    public void updateAll(ArrayList<diedEffect> effects){
        if(!effects.isEmpty()){
            for (int i=0;i<effects.size();i++) {
                effects.get(i).update();
            }
        }
    }

    public void drawAll(ArrayList<diedEffect> diedEffects, GraphicsContext gc){
        if(!diedEffects.isEmpty()){
            for (diedEffect diedEffect :diedEffects) {
                diedEffect.draw(gc);
            }
        }
    }

    @Override
    public boolean isDestroyed() {
        return false;
    }

    @Override
    public boolean isVisible() {
        return true;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }



}
