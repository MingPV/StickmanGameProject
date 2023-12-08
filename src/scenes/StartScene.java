package scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.media.MediaPlayer;



public class StartScene extends Scene {


    public StartScene(Stage stage) {
        super(createStartScene(stage), 800, 600);

    }

    private static VBox createStartScene(Stage stage) {
        VBox home = new VBox(30);
        home.setAlignment(Pos.CENTER);
        home.setStyle("-fx-background-color: transparent;" +
                "-fx-background-image: url(file:res/element/BackgroundHome.jpg);" +
                "-fx-background-size: cover;");

        Button btnStart = new Button("PLAY GAME");
        btnStart.setPrefSize(400, 60);
        btnStart.setBackground(new Background(new BackgroundFill(Color.WHITE.deriveColor(1, 1, 1, 0.8), null, null)));
        btnStart.setFont(new Font("Courier New", 30));
        btnStart.setOnAction(event -> {

            stage.setScene(new GameScene(stage));
        });

        Button btnSetting = new Button("SETTING");
        btnSetting.setBackground(new Background(new BackgroundFill(Color.WHITE.deriveColor(1, 1, 1, 0.8), null, null)));
        btnSetting.setPrefSize(150, 60);
        btnSetting.setFont(new Font("Courier New", 20));

        Button btnExit = new Button("EXIT");
        btnExit.setBackground(new Background(new BackgroundFill(Color.WHITE.deriveColor(1, 1, 1, 0.8), null, null)));
        btnExit.setPrefSize(150, 60);
        btnExit.setFont(new Font("Courier New", 20));
        btnExit.setOnMouseClicked(event -> {

            stage.close();
        });

        HBox menu = new HBox(50);
        menu.setAlignment(Pos.CENTER);
        menu.getChildren().addAll(btnSetting, btnExit);

        VBox.setMargin(btnStart, new Insets(200, 0, 0, 0));
        home.getChildren().addAll(btnStart, menu);

        return home;
    }

}
