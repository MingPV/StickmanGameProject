package profile;

import Item.*;
import entity.Player;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import main.KeyHandler;

import java.util.ArrayList;

public class ProfileBox {

    private Player player;

    private Image profileImage;
    private Image profileBoxImage;

    private int spriteCounter;
    private int spriteNum;
    private String profileImageURL;
    private String profileBoxURL;

    public ProfileBox(){
        setDefaultValues();
    }

    public void setDefaultValues(){

        setProfileImageURL("player/ProfileImage_1_1.png");
        setProfileBoxURL("player/ProfileBox_1.png");

        setProfileImage(new Image(String.valueOf(ClassLoader.getSystemResource(getProfileImageURL()))));
        setProfileBoxImage(new Image(String.valueOf(ClassLoader.getSystemResource(getProfileBoxURL()))));
        setPlayer(player);

    }


    public void draw(GraphicsContext gc){
        gc.drawImage(getProfileBoxImage(),0,0);
        gc.drawImage(getProfileImage(),0,0);
    }

    public void update(Player player){
        setPlayer(player);
        // add more
    }

    public Player getPlayer() {
        return player;
    }

    public int getSpriteCounter() {
        return spriteCounter;
    }

    public int getSpriteNum() {
        return spriteNum;
    }

    public String getProfileImageURL() {
        return profileImageURL;
    }

    public Image getProfileImage() {
        return profileImage;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setSpriteNum(int spriteNum) {
        this.spriteNum = spriteNum;
    }

    public void setSpriteCounter(int spriteCounter) {
        this.spriteCounter = spriteCounter;
    }

    public void setProfileImage(Image profileImage) {
        this.profileImage = profileImage;
    }

    public void setProfileImageURL(String profileImageURL) {
        this.profileImageURL = profileImageURL;
    }

    public Image getProfileBoxImage() {
        return profileBoxImage;
    }

    public String getProfileBoxURL() {
        return profileBoxURL;
    }

    public void setProfileBoxImage(Image profileBoxImage) {
        this.profileBoxImage = profileBoxImage;
    }

    public void setProfileBoxURL(String profileBoxURL) {
        this.profileBoxURL = profileBoxURL;
    }
}
