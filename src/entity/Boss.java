package entity;

import effect.ShadowEffect;
import javafx.scene.image.Image;

import static main.GamePanel.Effects;

public class Boss extends Monster {

    public Boss(){
        super();
    }
    public Boss(Player player){
        super(player);
        setEntityClass(Boss.class);
    }

    public void setDefaultValues(Player player) {

        setPlayer(player);

        setX(Math.floor(Math.random() *(800)));
        setY(Math.floor(Math.random() *(600)));
        setSpeed(0.4);
        setMaxHP(200);
        setHP(200);
        setDirection("down");
        setAngry(false);
        loadpic();
        setShadowEffect(new ShadowEffect(this));
        Effects.add(getShadowEffect());

    }

    public void loadpic(){
        setUp1(new Image("file:res/monster/boss_up_1.png"));
        setUp2(new Image("file:res/monster/boss_up_2.png"));
        setUp3(new Image("file:res/monster/boss_up_3.png"));
        setDown1(new Image("file:res/monster/boss_down_1.png"));
        setDown2(new Image("file:res/monster/boss_down_2.png"));
        setDown3(new Image("file:res/monster/boss_down_3.png"));
        setLeft1(new Image("file:res/monster/boss_left_1.png"));
        setLeft2(new Image("file:res/monster/boss_left_2.png"));
        setLeft3(new Image("file:res/monster/boss_left_3.png"));
        setRight1(new Image("file:res/monster/boss_right_1.png"));
        setRight2(new Image("file:res/monster/boss_right_2.png"));
        setRight3(new Image("file:res/monster/boss_right_3.png"));

        setHPB(new Image("file:res/player/hpdemored.png"));

    }



}
