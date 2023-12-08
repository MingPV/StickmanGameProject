package main;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Popup;


import java.io.File;

public class MusicController {
    public static MediaPlayer mediaPlayer;

    public static void playMusic() {
        String musicFile = "res/element/itty-bitty-8-bit-kevin-macleod-main-version-03-13-7983.mp3";
        Media backgroundMusic = new Media(new File(musicFile).toURI().toString());

        // Use the static variable instead of creating a local variable
        mediaPlayer = new MediaPlayer(backgroundMusic);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }


    private void togglePlayPause() {
        if (getMediaPlayer().getStatus() == MediaPlayer.Status.PLAYING) {
            getMediaPlayer().pause();
        } else {getMediaPlayer().play();
        }
    }

    public static void showMusicControllerPopup(Button button) {
        // Create the popup
        Popup popup = new Popup();
        popup.setAutoHide(true);

        // Create volume slider
        Slider volumeSlider = new Slider(0, 1, getMediaPlayer().getVolume());
        volumeSlider.setShowTickLabels(true);
        volumeSlider.setShowTickMarks(true);
        volumeSlider.valueProperty().addListener((observable, oldValue, newValue) -> setVolume(newValue.doubleValue()));

        // Create a label for volume
        Label volumeLabel = new Label("Volume:");

        // Create layout for the popup content
        HBox popupContent = new HBox(10);
        popupContent.getChildren().addAll(volumeLabel, volumeSlider);
        popupContent.setPadding(new Insets(10));

        // Add content to the popup
        popup.getContent().add(popupContent);

        // Show the popup below the setting button

        popup.show(button.getScene().getWindow(), button.getScene().getWindow().getX() + button.getLayoutX(),
                button.getScene().getWindow().getY() + button.getLayoutY() + button.getHeight());
    }

    private static void setVolume(double volume) {
       getMediaPlayer().setVolume(volume);
    }

    public static MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }
}
