// GameScene.java
package scenes;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import main.GamePanel;

public class GameScene extends Scene {

    public GameScene(Stage stage) {
        super(new StackPane(), 800, 600);

        StackPane root = (StackPane) getRoot();
        GamePanel gamePanel = new GamePanel(800, 600);
        root.getChildren().addAll(gamePanel);
        gamePanel.requestFocus();

        AnimationTimer animation = new AnimationTimer() {
            @Override
            public void handle(long l) {
                gamePanel.update();
                gamePanel.paintComponent();
            }
        };

        animation.start();
    }
}
