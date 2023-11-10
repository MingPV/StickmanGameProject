import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import main.GamePanel;

public class Main extends Application {
    public static void main(String[] args) {

        System.out.println("Hello and welcome!");
        Application.launch(args);

    }

    @Override
    public void start(Stage stage) throws Exception {
        StackPane root = new StackPane();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Coffee Man");

        GamePanel gamePanel = new GamePanel(800,600);

        root.getChildren().add(gamePanel);
        gamePanel.requestFocus();

        AnimationTimer animation = new AnimationTimer() {
            @Override
            public void handle(long l) {
                gamePanel.update();
                gamePanel.paintComponent();
            }
        };

        animation.start();
        stage.show();
    }
}