// StartScene.java
package scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import main.Main;

import java.nio.BufferUnderflowException;

public class StartScene extends Scene {

    public StartScene(Stage stage) {
        super(createStartScene(stage), 800, 600);
    }

    private static VBox createStartScene(Stage stage) {
        VBox home = new VBox(30);
        home.setAlignment(Pos.CENTER);
        home.setStyle("-fx-background-color: transparent;" +
                "-fx-background-size: cover;");

        Button btnStart = new Button("PLAY GAME");
        btnStart.setFont(new Font("Courier New", 40));
        btnStart.setStyle(
                "-fx-background-color: transparent;" +
                        "-fx-background-image: url('file:res/element/blockMenu.png');" +
                        "-fx-background-size: cover;"
        );
        btnStart.setPrefSize(600, 80);
        btnStart.setPadding(Insets.EMPTY);
        btnStart.setOnMouseClicked(event -> {
            // Pass the stage to the sceneGame method
            stage.setScene(new GameScene(stage));
            stage.show();
        });;

        Button btnSetting = new Button("SETTING");
        Button btnExit = new Button("EXIT");
        btnExit.setOnMouseClicked(event -> stage.close());

        HBox menu = new HBox(50);
        menu.setAlignment(Pos.CENTER);
        menu.getChildren().addAll(btnSetting, btnExit);

        VBox.setMargin(btnStart, new Insets(200, 0, 0, 0));
        home.getChildren().addAll(btnStart, menu);

        return home;
    }
}
