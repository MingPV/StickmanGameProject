package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import scenes.StartScene;

import java.io.File;

public class Main extends Application {
    private Stage stage;
    private MediaPlayer mediaPlayer;

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
        playMusic();

    }

    public void playMusic(){

        String musicFile = "res/element/itty-bitty-8-bit-kevin-macleod-main-version-03-13-7983.mp3";
        Media backgroundMusic = new Media(new File(musicFile).toURI().toString());
        mediaPlayer = new MediaPlayer(backgroundMusic);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();


    }
}
