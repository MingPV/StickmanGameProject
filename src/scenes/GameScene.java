

package scenes;

import javafx.animation.AnimationTimer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import main.GamePanel;
import javafx.scene.control.Button;
import scenes.SelectedScene;

import java.awt.*;

public class GameScene extends Scene {

    public GameScene(Stage stage) {

        super(new StackPane(), 800, 600);
        System.out.println("selected Character : " + SelectedScene.getSelectedCharacter());
        StackPane root = (StackPane) getRoot();
        GamePanel gamePanel = new GamePanel(800, 600);
        root.getChildren().addAll(gamePanel);

        gamePanel.requestFocus();

        AnimationTimer animation = new AnimationTimer() {
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

