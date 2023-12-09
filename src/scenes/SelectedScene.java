<<<<<<< HEAD
package scenes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class SelectedScene extends Scene {
    private static String playerName;
    private static String selectedCharacter;

    public SelectedScene(Stage stage) {
        super(createSelectedScene(stage), 800, 600);
        playerName = "";
        selectedCharacter = "";
    }

    private static VBox createSelectedScene(Stage stage) {
        Text playerText = new Text("PLAYER");
        playerText.setFont(new Font("Courier New", 40));

        ImageView backgroundRectangle = new ImageView(new Image("file:res/element/pixil-frame-0 (20).png"));
        backgroundRectangle.setFitWidth(200);
        backgroundRectangle.setFitHeight(60);

        StackPane header = new StackPane();
        header.getChildren().addAll(backgroundRectangle, playerText);

        TextField textField = new TextField("Enter Player's name ...");
        textField.setMaxWidth(200); // Set the desired width of the TextField
        textField.setFont(new Font("Courier New", 14)); // Set the font size of the TextField

        textField.setOnAction(event -> {
            playerName = textField.getText();
        });

        Image charA = new Image("file:res/element/characterA.jpg");
        Image charB = new Image("file:res/element/characterB.png");
        ImageView characterA = new ImageView(charA);
        ImageView characterB = new ImageView(charB);
        characterA.setFitHeight(250);
        characterA.setFitWidth(200);
        characterB.setFitHeight(250);
        characterB.setFitWidth(200);

        ImageView backgroundRectangle2 = new ImageView(new Image("file:res/element/longBox.png.jpg"));
        backgroundRectangle.setFitWidth(200);
        backgroundRectangle.setFitHeight(60);
        Text selectedCharacterText = new Text("Selected Character");
        StackPane select = new StackPane();
        select.getChildren().addAll(backgroundRectangle2, selectedCharacterText);

        Button character1 = new Button();
        character1.setGraphic(characterA);
        character1.setOnAction(event -> selectedCharacter = "1");

        Button character2 = new Button();
        character2.setGraphic(characterB);
        character2.setOnAction(event -> selectedCharacter = "2");

        Button playbtn = new Button("PLAY");
        playbtn.setOnAction(event -> {
            Popup popup = new Popup();

            if (selectedCharacter.isBlank()) {
                Text warning = new Text("Please select the Character");
                popup.getContent().addAll(warning);
                popup.show(playbtn.getScene().getWindow(), playbtn.getScene().getWindow().getX() + playbtn.getLayoutX(),
                        playbtn.getScene().getWindow().getY() + playbtn.getLayoutY() + playbtn.getHeight());
            } else {
                popup.hide();
                stage.setScene(new GameScene(stage));
            }
        });


        HBox selectedMenu = new HBox(50);
        selectedMenu.getChildren().addAll(character1, character2);
        selectedMenu.setAlignment(Pos.CENTER);

        VBox root = new VBox(20);
        root.getChildren().addAll(header, textField, select, selectedMenu, playbtn);
        root.setAlignment(Pos.CENTER);

        root.setStyle("-fx-background-color: transparent;" +
                "-fx-background-image: url(file:res/element/BackgroundHome.jpg);" +
                "-fx-background-size: cover;");

        return root;
    }

    public String getPlayerName() {
        return playerName;
    }

    public static String getSelectedCharacter() {
        return selectedCharacter;
    }
}
||||||| a5af869
=======
package scenes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;

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

        ImageView backgroundRectangle = new ImageView(new Image("file:res/element/pixil-frame-0 (20).png"));
        backgroundRectangle.setFitWidth(200);
        backgroundRectangle.setFitHeight(60);

        StackPane header = new StackPane();
        header.getChildren().addAll(backgroundRectangle, playerText);

        TextField textField = new TextField("Enter Player's name ...");
        textField.setMaxWidth(200); // Set the desired width of the TextField
        textField.setFont(new Font("Courier New", 14)); // Set the font size of the TextField

        textField.setOnAction(event -> {
            playerName = textField.getText();
        });

        Image charA = new Image("file:res/element/characterA.jpg");
        Image charB = new Image("file:res/element/characterB.png");
        ImageView characterA = new ImageView(charA);
        ImageView characterB = new ImageView(charB);
        characterA.setFitHeight(250);
        characterA.setFitWidth(200);
        characterB.setFitHeight(250);
        characterB.setFitWidth(200);

        ImageView backgroundRectangle2 = new ImageView(new Image("file:res/element/longBox.png.jpg"));
        backgroundRectangle.setFitWidth(200);
        backgroundRectangle.setFitHeight(60);
        Text selectedCharacterText = new Text("Selected Character");
        StackPane select = new StackPane();
        select.getChildren().addAll(backgroundRectangle2, selectedCharacterText);

        Button character1 = new Button();
        character1.setGraphic(characterA);
        character1.setOnAction(event -> selectedCharacter = "1");

        Button character2 = new Button();
        character2.setGraphic(characterB);
        character2.setOnAction(event -> selectedCharacter = "2");

        Button playbtn = new Button("PLAY");
        playbtn.setOnAction(event -> {
            Popup popup = new Popup();

            if (selectedCharacter.isBlank()) {
                Text warning = new Text("Please select the Character");
                popup.getContent().addAll(warning);
                popup.show(playbtn.getScene().getWindow(), playbtn.getScene().getWindow().getX() + playbtn.getLayoutX(),
                        playbtn.getScene().getWindow().getY() + playbtn.getLayoutY() + playbtn.getHeight());
            } else {
                popup.hide();
                stage.setScene(new GameScene(stage));
            }
        });


        HBox selectedMenu = new HBox(50);
        selectedMenu.getChildren().addAll(character1, character2);
        selectedMenu.setAlignment(Pos.CENTER);

        VBox root = new VBox(20);
        root.getChildren().addAll(header, textField, select, selectedMenu, playbtn);
        root.setAlignment(Pos.CENTER);

        root.setStyle("-fx-background-color: transparent;" +
                "-fx-background-image: url(file:res/element/BackgroundHome.jpg);" +
                "-fx-background-size: cover;");

        return root;
    }

    public String getPlayerName() {
        return playerName;
    }

    public static String getSelectedCharacter() {
        return selectedCharacter;
    }
}
>>>>>>> 63d525d7974dc4166ae82e9a27c5f21046b5e411
