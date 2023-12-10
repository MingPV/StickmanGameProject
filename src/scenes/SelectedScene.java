package scenes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import scenes.*;



public class SelectedScene extends Scene {
    public static String playerName;
    public static String selectedCharacter;

    public SelectedScene(Stage stage) {
        super(createSelectedScene(stage), 800, 600);
        playerName = "";
        selectedCharacter = "";
    }
    private static VBox createSelectedScene(Stage stage) {
        Text playerText = new Text("PLAYER");
        playerText.setFont(new Font("Courier New", 40));

        StackPane header = new StackPane();
        ImageView backgroundRectangle = new ImageView(new Image("file:res/element/player.png"));
        header.getChildren().addAll(backgroundRectangle, playerText);

        TextField textField = new TextField("Enter Player's name ...");
        textField.setAlignment(Pos.CENTER);
        textField.setStyle("-fx-background-color: transparent;" +
                "-fx-background-image: url(file:res/element/ENTER.png);" +
                "-fx-background-size: cover;" + "-fx-background-size: contain;");
        textField.setMaxWidth(320);
        textField.setFont(Font.font("Courier New", FontWeight.BOLD, 14));
        textField.setOnAction(event -> {
            SelectedScene.playerName = textField.getText();
        });

        VBox characterPane = new VBox(20);
        characterPane.setAlignment(Pos.CENTER);

        Button character1 = new Button();
        character1.setPrefSize(200, 250);
        character1.setStyle("-fx-background-color: transparent;" +
                "-fx-background-image: url(file:res/player/CharA.gif);" +
                "-fx-background-size: cover;");

        Button character2 = new Button();
        character2.setPrefSize(200, 250);
        character1.setOnAction(event -> {
            SelectedScene.selectedCharacter = "1";
            character1.setStyle("-fx-background-color: transparent;" +
                    "-fx-background-image: url(file:res/player/CharAwithFrame.gif);" +
                    "-fx-background-size: cover;");
            character2.setStyle("-fx-background-color: transparent;" +
                    "-fx-background-image: url(file:res/player/CharB.gif);" +
                    "-fx-background-size: cover;");
        });
        character2.setStyle("-fx-background-color: transparent;" +
                "-fx-background-image: url(file:res/player/CharB.gif);" +
                "-fx-background-size: cover;");
        character2.setOnAction(event -> {
            SelectedScene.selectedCharacter = "2";
            character1.setStyle("-fx-background-color: transparent;" +
                    "-fx-background-image: url(file:res/player/CharA.gif);" +
                    "-fx-background-size: cover;");
            character2.setStyle("-fx-background-color: transparent;" +
                    "-fx-background-image: url(file:res/player/CharBwithFrame.gif);" +
                    "-fx-background-size: cover;");

        });

        HBox charSelection = new HBox(50);

        charSelection.setAlignment(Pos.CENTER);
        charSelection.getChildren().addAll(character1, character2);


        characterPane.getChildren().addAll(charSelection);

        Button playbtn = new Button("LET'S PLAY !");
        playbtn.setPrefSize(300, 60);
        playbtn.setFont(Font.font("Courier New", FontWeight.BOLD, 30));
        playbtn.setStyle("-fx-background-color: transparent;" +
                "-fx-background-image: url(file:res/element/shortBox.png);" +
                "-fx-background-size: cover;"  + "-fx-background-repeat: no-repeat;");
        playbtn.setOnAction(event -> {
            stage.setScene(new GameScene(stage));
        });

        VBox root = new VBox(20);
        root.getChildren().addAll(header, textField, characterPane, playbtn);
        root.setAlignment(Pos.CENTER);

        root.setStyle("-fx-background-color: transparent;" +
                "-fx-background-image: url(file:res/element/BackgroundHome.jpg);" +
                "-fx-background-size: cover;");
        root.setAlignment(Pos.CENTER);

        return root;
    }



    public String getPlayerName() {
        return playerName;
    }

    public static String getSelectedCharacter() {
        return selectedCharacter;
    }
}