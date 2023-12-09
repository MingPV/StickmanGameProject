package main;

import Item.BaseForItem;
import Item.BaseItem;
import effect.BaseEffect;
import effect.Effect;
import effect.diedEffect;
import entity.Monster;
import entity.Player;
import font.Number;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import tile.Background;

import java.util.ArrayList;


public class GamePanel extends Canvas {

    KeyHandler keyH = new KeyHandler();
    Player player = new Player();
    Monster monster = new Monster(player);
    public static Number number = new Number();
    BaseEffect Effect = new BaseEffect(monster,player);
    BaseItem baseItemOnFloor = new BaseItem(monster,player);
    public static ArrayList<Monster> monsters = new ArrayList<Monster>();
    public static ArrayList<BaseEffect> Effects = new ArrayList<BaseEffect>();
    public static ArrayList<BaseItem> itemOnFloors = new ArrayList<BaseItem>();


    Background background = new Background();

    GraphicsContext gc = this.getGraphicsContext2D();

    public GamePanel(double width, double height){
        super(width, height);
        this.setVisible(true);
        addkeylistener();


        gc.setFill(Color.BLACK);
        //gc.fillRect(0,0,width, height);

        //fix some shadow
        Effects.remove(monster.getShadowEffect());

    }


    public void addkeylistener(){
        this.setOnKeyPressed((KeyEvent event) -> {
            KeyHandler.setKeyPressed(event.getCode(), true);
        });

        this.setOnKeyReleased((KeyEvent event) -> {
            KeyHandler.setKeyPressed(event.getCode(), false);
        });

    }

    public void update() throws InterruptedException {
        // update

        player.update();
        monster.updateAll(monsters);
        Effect.updateAll(player);
        baseItemOnFloor.updateAll(player);

    }

    public void paintComponent(){
        background.draw(gc);
        baseItemOnFloor.drawAll(gc);
        player.draw(gc);
        monster.drawAll(monsters,gc);
        Effect.drawAll(gc);
        player.getInventoryBar().draw(gc);

    }


}
