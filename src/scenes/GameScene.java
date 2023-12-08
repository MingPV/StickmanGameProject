

package scenes;

import javafx.animation.AnimationTimer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import main.GamePanel;
import javafx.scene.control.Button;
<<<<<<< HEAD
import scenes.SelectedScene;
||||||| 84ba862
=======
import main.KeyHandler;
>>>>>>> a5af8699b9248a6bde3284e128ded0726a31656d

import java.awt.*;

public class GameScene extends Scene {

    public static AnimationTimer animation;

    public GameScene(Stage stage) {

        super(new StackPane(), 800, 600);
        System.out.println("selected Character : " + SelectedScene.getSelectedCharacter());
        StackPane root = (StackPane) getRoot();
        GamePanel gamePanel = new GamePanel(800, 600);
        root.getChildren().addAll(gamePanel);

        gamePanel.requestFocus();

<<<<<<< HEAD
        AnimationTimer animation = new AnimationTimer() {
||||||| 84ba862


        AnimationTimer animation = new AnimationTimer() {
=======


        animation = new AnimationTimer() {
>>>>>>> a5af8699b9248a6bde3284e128ded0726a31656d
            @Override
            public void handle(long l) {
                try {
                    gamePanel.update();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                gamePanel.paintComponent();
            }
        };

        animation.start();



    }
}

