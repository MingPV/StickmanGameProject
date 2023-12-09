package scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import main.MusicController;
<<<<<<< HEAD
||||||| a5af869

import java.io.File;

=======

>>>>>>> 63d525d7974dc4166ae82e9a27c5f21046b5e411
public class StartScene extends Scene {
    public StartScene(Stage stage) {
        super(createStartScene(stage), 800, 600);
    }
    private static VBox createStartScene(Stage stage) {
        VBox home = new VBox(30);
        home.setAlignment(Pos.CENTER);
        home.setStyle("-fx-background-color: transparent;" +
                "-fx-background-image: url(file:res/element/background.gif);" +
                "-fx-background-size: cover;");

        Button btnStart = createButton("PLAY GAME", "file:res/element/longBox.png");
        btnStart.setFont(Font.font("Courier New", FontWeight.BOLD, 30));

<<<<<<< HEAD
        btnStart.setPrefWidth(540);
        btnStart.setPrefHeight(60);
        btnStart.setOnAction(event -> {stage.setScene(new SelectedScene(stage));});
||||||| a5af869
        Button btnSetting = new Button("SETTING");
        btnSetting.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Color.WHITE.deriveColor(1, 1, 1, 0.8), null, null)));
        btnSetting.setPrefSize(150, 60);
        btnSetting.setFont(new javafx.scene.text.Font("Courier New", 20));
        btnSetting.setOnAction(event -> {
            MusicController.showMusicControllerPopup(btnStart);
        });
=======
        btnStart.setPrefWidth(540);
        btnStart.setPrefHeight(60);
        btnStart.setOnAction(event -> {stage.setScene(new SelectedScene(stage));});

        Button btnSetting = createButton("SETTING", "file:res/element/shortBox.png");
        btnSetting.setOnAction(event -> {
            MusicController.showMusicControllerPopup(btnStart);});
>>>>>>> 63d525d7974dc4166ae82e9a27c5f21046b5e411

<<<<<<< HEAD
        Button btnSetting = createButton("SETTING", "file:res/element/shortBox.png");
        btnSetting.setOnAction(event -> {MusicController.showMusicControllerPopup(btnStart);});

        Button btnExit = createButton("EXIT", "file:res/element/shortBox.png");
        btnExit.setOnMouseClicked(event -> {stage.close();});
||||||| a5af869
        Button btnExit = new Button("EXIT");
        btnExit.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Color.WHITE.deriveColor(1, 1, 1, 0.8), null, null)));
        btnExit.setPrefSize(150, 60);
        btnExit.setFont(new javafx.scene.text.Font("Courier New", 20));
        btnExit.setOnMouseClicked(event -> {
            stage.close();
        });
=======
        Button btnExit = createButton("EXIT", "file:res/element/shortBox.png");
        btnExit.setOnMouseClicked(event -> {stage.close();});
>>>>>>> 63d525d7974dc4166ae82e9a27c5f21046b5e411

        HBox menu = new HBox(50);
        menu.setAlignment(Pos.CENTER);
        menu.getChildren().addAll(btnSetting, btnExit);

        VBox.setMargin(btnStart, new Insets(200, 0, 0, 0));
        home.getChildren().addAll(btnStart, menu);

        return home;
    }

    private static Button createButton(String string, String imagePath) {
        Button button = new Button(string);
        button.setFont(Font.font("Courier New",FontWeight.BOLD,20));
        button.setOnMouseEntered(event -> {button.setCursor(Cursor.HAND);});
        button.setOnMouseExited(event -> {button.setCursor(Cursor.DEFAULT);});
        button.setPrefWidth(250);
        button.setPrefHeight(50);
        button.setStyle("-fx-background-color: transparent;" + "-fx-background-image: url(" + imagePath + ");" + "-fx-background-size: cover;");
        return button;
    }
}
