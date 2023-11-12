package main;

import entity.Monster;
import entity.Player;
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
    public static ArrayList<Monster> monsters = new ArrayList<Monster>();


    Background background = new Background();

    GraphicsContext gc = this.getGraphicsContext2D();

    public GamePanel(double width, double height){
        super(width, height);
        this.setVisible(true);
        addkeylistener();


        gc.setFill(Color.BLACK);
        //gc.fillRect(0,0,width, height);

    }


    public void addkeylistener(){
        this.setOnKeyPressed((KeyEvent event) -> {
            KeyHandler.setKeyPressed(event.getCode(), true);
        });

        this.setOnKeyReleased((KeyEvent event) -> {
            KeyHandler.setKeyPressed(event.getCode(), false);
        });

    }

    public void update(){
        // update

        player.update();
        monster.updateAll(monsters);


    }

    public void paintComponent(){
        background.draw(gc);
        player.draw(gc);
        monster.drawAll(monsters,gc);
    }


}
