package tile;

public abstract class Tile {

    private int x, y;
    private int speed;

    private String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSpeed() {
        return speed;
    }

    public String getDirection() {
        return direction;
    }
}
