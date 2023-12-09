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

        btnStart.setPrefWidth(540);
        btnStart.setPrefHeight(60);
        btnStart.setOnAction(event -> {stage.setScene(new SelectedScene(stage));});

        Button btnSetting = createButton("SETTING", "file:res/element/shortBox.png");
        btnSetting.setOnAction(event -> {
            MusicController.showMusicControllerPopup(btnStart);});

        Button btnExit = createButton("EXIT", "file:res/element/shortBox.png");
        btnExit.setOnMouseClicked(event -> {stage.close();});

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
