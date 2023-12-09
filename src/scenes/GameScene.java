

package scenes;

import javafx.animation.AnimationTimer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import main.GamePanel;
import javafx.scene.control.Button;
<<<<<<< HEAD
<<<<<<< HEAD
import scenes.SelectedScene;
||||||| 84ba862
=======
import main.KeyHandler;
>>>>>>> a5af8699b9248a6bde3284e128ded0726a31656d
||||||| a5af869
import main.KeyHandler;
=======
import scenes.SelectedScene;
>>>>>>> 63d525d7974dc4166ae82e9a27c5f21046b5e411

import java.awt.*;

public class GameScene extends Scene {

    public GameScene(Stage stage) {

        super(new StackPane(), 800, 600);
        System.out.println("selected Character : " + SelectedScene.getSelectedCharacter());
        StackPane root = (StackPane) getRoot();
        GamePanel gamePanel = new GamePanel(800, 600);
        root.getChildren().addAll(gamePanel);

        gamePanel.requestFocus();

<<<<<<< HEAD
<<<<<<< HEAD
        AnimationTimer animation = new AnimationTimer() {
||||||| 84ba862


        AnimationTimer animation = new AnimationTimer() {
=======


        animation = new AnimationTimer() {
>>>>>>> a5af8699b9248a6bde3284e128ded0726a31656d
||||||| a5af869


        animation = new AnimationTimer() {
=======
        AnimationTimer animation = new AnimationTimer() {
>>>>>>> 63d525d7974dc4166ae82e9a27c5f21046b5e411
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

