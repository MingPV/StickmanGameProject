package main;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Popup;

import java.io.File;

public class MusicController {
    private static MediaPlayer mediaPlayer;

    public static void playMusic() {
        String musicFile = "res/element/soundtrack.mp3";
        Media backgroundMusic = new Media(new File(musicFile).toURI().toString());

        mediaPlayer = new MediaPlayer(backgroundMusic);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }

    public static void showMusicControllerPopup(Button button) {

        Popup popup = new Popup();
        popup.setAutoHide(false);

        Slider volumeSlider = new Slider(0, 100, mediaPlayer.getVolume() * 100);
        volumeSlider.setShowTickLabels(false);
        volumeSlider.setShowTickMarks(false);
        volumeSlider.valueProperty().addListener((observable, oldValue, newValue) -> setVolume(newValue.doubleValue() / 100));
        volumeSlider.setPrefWidth(200);
        volumeSlider.setPadding(new Insets(8, 0, 8, 0));
        volumeSlider.setStyle("-fx-control-inner-background: #464646;");
        volumeSlider.setOnMouseEntered(event -> volumeSlider.setCursor(Cursor.HAND));
        volumeSlider.setOnMouseExited(event -> volumeSlider.setCursor(Cursor.DEFAULT));

        Image sound_open = new Image("file:res/element/sound.png");
        Image sound_close = new Image("file:res/element/close_Volume.png");
        ImageView soundLoud = new ImageView(sound_open);
        soundLoud.setFitWidth(20);
        soundLoud.setFitHeight(20);

        ImageView soundLow = new ImageView(sound_close);
        soundLow.setFitWidth(20);
        soundLow.setFitHeight(20);

        Button soundBtn = new Button();
        soundBtn.setGraphic(soundLoud);
        soundBtn.setAlignment(Pos.CENTER);
        soundBtn.setStyle("-fx-background-color: transparent;");
        soundBtn.setOnAction(event -> {
            if(mediaPlayer.getVolume() != 0){
                setVolume(0);
                soundBtn.setGraphic(soundLow);
            }
            else {
                setVolume(100);
                soundBtn.setGraphic(soundLoud);
            }
        });

        Image image = new Image("file:res/element/close.png");
        ImageView closeImage = new ImageView(image);

        Button closebtn = new Button();
        closebtn.setGraphic(closeImage);
        closebtn.setStyle("-fx-background-color: transparent;");
        closebtn.setOnAction(event -> {popup.hide();});

        HBox popupSetting = new HBox(10);
        popupSetting.setMinSize(350, 20);
        popupSetting.getChildren().addAll(soundBtn, volumeSlider, closebtn);
        popupSetting.setPadding(new Insets(15, 15, 15, 30));
        popupSetting.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        popupSetting.setStyle("-fx-background-color: transparent;" +
                "-fx-background-image: url(file:res/element/shortBox.png);" +
                "-fx-background-size: cover;");


        popup.getContent().addAll(popupSetting);

        popup.show(button.getScene().getWindow(), button.getScene().getWindow().getX() + button.getLayoutX(),
                button.getScene().getWindow().getY() + button.getLayoutY() +  button.getHeight() + 120);
    }

    private static void setVolume(double volume) {
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(volume);
        }
    }

}
