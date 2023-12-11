package main;

import Background.Background;
import Item.BaseItem;
import effect.BaseEffect;
import entity.*;
import font.Number;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

import java.util.ArrayList;


public class GamePanel extends Canvas {

    public static Number number = new Number();
    public static ArrayList<Monster> monsters = new ArrayList<>();
    public static ArrayList<BaseEffect> Effects = new ArrayList<>();
    public static ArrayList<BaseItem> itemOnFloors = new ArrayList<>();
    public static ArrayList<BaseProp> Props = new ArrayList<>();
    public static boolean GameOver = false;
    Player player = new Player();
    Monster monster = new Monster(player);
    BaseEffect Effect = new BaseEffect(monster, player);
    BaseItem baseItemOnFloor = new BaseItem(monster, player);
    BaseProp baseProp = new BaseProp(0, 0);
    Background background = new Background();

    GraphicsContext gc = this.getGraphicsContext2D();

    public GamePanel(double width, double height) {
        super(width, height);
        this.setVisible(true);
        addKeyListener();


        gc.setFill(Color.BLACK);

        //fix shadow
        Effects.remove(monster.getShadowEffect());
        setAllProp();

    }


    public void addKeyListener() {
        this.setOnKeyPressed((KeyEvent event) -> KeyHandler.setKeyPressed(event.getCode(), true));

        this.setOnKeyReleased((KeyEvent event) -> KeyHandler.setKeyPressed(event.getCode(), false));

    }

    public void update() throws InterruptedException {
        // update

        if (player != null) {
            player.update();
            monster.updateAll(monsters);
            Effect.updateAll(player);
            baseItemOnFloor.updateAll(player);
            baseProp.updateAll();
        }

    }

    public void paintComponent() {

        if (player != null) {
            background.draw(gc);
            baseItemOnFloor.drawAll(gc);
            Effect.drawAll(gc);
            monster.drawAll(monsters, gc);
            player.draw(gc);
            player.getInventoryBar().draw(gc);
            baseProp.drawAll(gc);
        }

    }

    public void setAllProp() {
        Props.add(new ChristmasTree(-55, 450));
        Props.add(new ChristmasTree(-70, 300));
        Props.add(new ChristmasTree(-80, 120));
        Props.add(new Gift(25, 575));
        Props.add(new Gift2(5, 570));
        Props.add(new ChristmasTree(700, 450));
        Props.add(new Gift(780, 574));
        Props.add(new Gift2(765, 570));
        Props.add(new Snowman(670, 502));

    }

    public void setAllDefaultValues() {
        player = null;
        monsters.clear();
        Effects.clear();
        itemOnFloors.clear();
        Props.clear();
    }


}
