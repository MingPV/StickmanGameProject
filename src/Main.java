import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import main.GamePanel;


public class Main extends Application {

    public Stage stage;
    public static void main(String[] args) {

        System.out.println("Hello and welcome!");
        Application.launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        stage.setTitle("Coffee Man");
        stage.setScene(SceneStart());
        stage.show();
    }

    public Scene SceneGame(){
        StackPane root = new StackPane();
        Scene scene = new Scene(root);

        GamePanel gamePanel = new GamePanel(800,600);

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
        return scene;
    }

    public Scene SceneStart(){
        VBox home = new VBox(30);
        home.setAlignment(Pos.CENTER);
        home.setStyle("-fx-background-color: transparent;" +
                "-fx-background-image: url(file:res/element/backgroundHome.png);" +
                "-fx-background-size: cover;"
        );
        //Button Start - click to play game
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
            stage.setScene(SceneGame());
            stage.show();
        });
        //Function Setting --- to set the volume of sound or sound effect(optional)
        Button btnSetting = new Button("SETTING");
        btnSetting.setPrefSize(250, 70);
        btnSetting.setFont(new Font("Courier New", 30));
        btnSetting.setStyle(
                "-fx-background-color: transparent;" +
                        "-fx-background-image: url('file:res/element/blockMenuSmall.png');" +
                        "-fx-background-size: cover;"
        );
        //exit button
        Button btnExit = new Button("EXIT");
        btnExit.setPrefSize(250, 70);
        btnExit.setFont(new Font("Courier New", 30));
        btnExit.setStyle(
                "-fx-background-color: transparent;" +
                        "-fx-background-image: url('file:res/element/blockMenuSmall.png');" +
                        "-fx-background-size: cover;"
        );
        btnExit.setOnMouseClicked(event -> {
            stage.close();
        });

        HBox menu = new HBox(50); // 20 is the spacing between buttons
        menu.setAlignment(Pos.CENTER);
        menu.getChildren().addAll(btnSetting, btnExit);

        VBox.setMargin(btnStart, new Insets(200, 0, 0, 0));
        home.getChildren().addAll(btnStart, menu );

        return new Scene(home, 800, 600);

    }
}