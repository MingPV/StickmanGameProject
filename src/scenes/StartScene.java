package scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;
import main.MusicController;

public class StartScene extends Scene {
    public StartScene(Stage stage) {
        super(createStartScene(stage), 800, 600);
    }
    private static VBox createStartScene(Stage stage) {

        VBox root = new VBox(20);

        //Start Button
        Button btnStart = createButton("PLAY GAME", "file:res/element/longBox.png");
        btnStart.setFont(Font.font("Courier New", FontWeight.BOLD, 30));
        btnStart.setPrefWidth(540);
        btnStart.setPrefHeight(60);
        btnStart.setOnAction(event -> {stage.setScene(new SelectedScene(stage));});

        //Menu
        HBox menu = new HBox(10);
        menu.setAlignment(Pos.TOP_CENTER);
        //setting
        Button btnSetting = createButton("SETTING", "file:res/element/shortBox.png");
        HBox control = MusicController.showMusicControllerPopup();
        btnSetting.setOnAction(event -> {
            control.setVisible(!control.isVisible());
        });
        //how to play
        Button btnHowToPlay =createButton("HOW TO PLAY", "file:res/element/shortBox.png");
        VBox rules = new VBox(5);

        Text text = new Text("RULE");
        text.setFont(Font.font("Courier New", FontWeight.BOLD, 12));
        Text rule1 = rule("1.Enter the player's name and choose a character.");
        Text rule2 = rule("2.Move: A S W D, Selection: Q E, Use Item: J, Attack: K");
        Text rule3 = rule("3.the battle starts when a player approach a monster.");
        Text rule4 = rule("4.You'll get item when the monster die.");
        Text rule5 = rule("5.Game ends when health runs out/sleepiness bar is full.");
        rules.getChildren().addAll(text, rule1, rule2, rule3, rule4, rule5);
        rules.setAlignment(Pos.BASELINE_LEFT);
        rules.setVisible(false);
        btnHowToPlay.setOnAction(event -> {
            rules.setVisible(!rules.isVisible());
        });

        rules.setPadding(new Insets(10, 0, 20, 10));
        rules.setStyle("-fx-background-color: transparent;" +
                "-fx-background-image: url(file:res/element/ruleBox.png);" +
                "-fx-background-size: cover;"+"-fx-background-size: contain;" + "-fx-background-repeat: no-repeat;");
        //exit
        Button btnExit = createButton("EXIT", "file:res/element/shortBox.png");
        btnExit.setOnMouseClicked(event -> {stage.close();});

        //detailed
        HBox detail = new HBox(20);
        detail.setAlignment(Pos.CENTER);
        detail.getChildren().addAll(control, rules);
        menu.getChildren().addAll(btnSetting, btnHowToPlay, btnExit);

        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(200, 0, 0, 0));
        root.setStyle("-fx-background-color: transparent;" +
                "-fx-background-image: url(file:res/element/background.gif);" +
                "-fx-background-size: cover;");
        root.getChildren().addAll(btnStart, menu, detail);

        return root;
    }

    private static Button createButton(String string, String imagePath) {
        Button button = new Button(string);
        button.setFont(Font.font("Courier New",FontWeight.BOLD,20));
        button.setOnMouseEntered(event -> {button.setCursor(Cursor.HAND);});
        button.setOnMouseExited(event -> {button.setCursor(Cursor.DEFAULT);});
        button.setPrefWidth(230);
        button.setPrefHeight(45);
        button.setStyle("-fx-background-color: transparent;" + "-fx-background-image: url(" + imagePath + ");" + "-fx-background-size: cover;");
        return button;
    }

    private static Text rule(String rule){
        Text text = new Text(rule);
        text.setFont(Font.font("Courier New", 12));
        return text;
    }


}