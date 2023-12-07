package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import scenes.GameScene;
import scenes.StartScene;


public class Main extends Application {

    private Stage stage;


    public static void main(String[] args) {

        System.out.println("Hello and welcome!");
        Application.launch(args);

    }

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        stage.setTitle("Coffee Man");

        Scene sceneStart = new StartScene(stage);

        stage.setScene(sceneStart);
        stage.show();
    }


}