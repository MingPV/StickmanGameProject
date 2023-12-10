package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import scenes.StartScene;

import main.MusicController;

import java.io.File;

public class Main extends Application {
    private Stage stage;

    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        stage.setTitle("Coffee Man");

        Scene sceneStart = new StartScene(stage);

        stage.setScene(sceneStart);
        stage.show();
        MusicController.playMusic();

    }


}
