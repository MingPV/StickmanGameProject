

package scenes;

import javafx.animation.AnimationTimer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import main.GamePanel;
import javafx.scene.control.Button;

import java.awt.*;

public class GameScene extends Scene {

    public GameScene(Stage stage) {
        super(new StackPane(), 800, 600);

        StackPane root = (StackPane) getRoot();
        GamePanel gamePanel = new GamePanel(800, 600);
       /* Button restartBtn = new Button("Restart");

        StackPane.setAlignment(restartBtn, Pos.TOP_RIGHT);
        StackPane.setMargin(restartBtn, new Insets(20));
        restartBtn.setOnAction(event ->
                stage.setScene(new StartScene(stage)));*/
        //root.getChildren().addAll(restartBtn);
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
