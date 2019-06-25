/* import javax.swing.*;
import java.awt.*;

public class Bomb {
    private int x;
    private int y;

    private int xSpeed;
    private int ySpeed;

    private Color color;
    private int width;
    private int height;


    public Bomb(int x, int y, int width,int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;

        ySpeed = 2;
    }


    public void draw(Graphics UiBomb){
        ImageIcon BombIcon = new ImageIcon(getClass().getClassLoader().getResource("images/bomb.png"));
        Image BombImage = BombIcon.getImage();
        UiBomb.drawImage(BombImage, x, y, width, height, null);
    }

    public void moveBomb(int gameWidth, int gameHeight, int GunHeight){

        y += ySpeed;
        ySpeed += 1;
    }

    public Rectangle getBound() {
        Rectangle BombRect = new Rectangle(x, y, width, height);
        return BombRect;
    }

}

*/