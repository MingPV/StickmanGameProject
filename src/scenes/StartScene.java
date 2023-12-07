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

public class StartScene extends Scene {

    public StartScene(Stage stage) {
        super(createStartScene(stage), 800, 600);
    }

    private static VBox createStartScene(Stage stage) {
        VBox home = new VBox(30);
        home.setAlignment(Pos.CENTER);
        home.setStyle("-fx-background-color: transparent;" +
                "-fx-background-size: cover;");

        Button btnStart = createStyledButton("PLAY GAME", "res/element/blockMenu.png", 600, 80, 40);
        btnStart.setOnAction(event -> stage.setScene(new GameScene(stage)));

        Button btnSetting = createStyledButton("SETTING", "res/element/blockMenuSmall.png", 250, 70, 30);
        Button btnExit = createStyledButton("EXIT", "res/element/blockMenuSmall.png", 250, 70, 30);
        btnExit.setOnMouseClicked(event -> stage.close());

        HBox menu = new HBox(50);
        menu.setAlignment(Pos.CENTER);
        menu.getChildren().addAll(btnSetting, btnExit);

        VBox.setMargin(btnStart, new Insets(200, 0, 0, 0));
        home.getChildren().addAll(btnStart, menu);

        return home;
    }

    public static Button createStyledButton(String text, String backgroundImage, double width, double height, double fontSize) {
        Button button = new Button(text);
        button.setFont(new Font("Courier New", fontSize));
        button.setStyle(
                "-fx-background-color: transparent;" +
                        "-fx-background-image: url('" + Main.class.getResource(backgroundImage) + "');" +
                        "-fx-background-size: cover;"
        );
        button.setPrefSize(width, height);
        button.setPadding(new Insets(0));
        return button;
    }
}
