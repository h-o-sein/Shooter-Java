import javax.swing.*;
import java.awt.*;

public class Birds {

    private int x;
    private int y;

    private int xSpeed;
    private int ySpeed;

    private int yT;

    private Color color;
    private int width;
    private int height;


    public Birds(int x, int y, int width,int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;

        //yT = 1;

        xSpeed = 2;
        ySpeed = 2;
    }


    public void draw(Graphics UiBirds){
        /*UiBirds.setColor(color);
        UiBirds.fillOval(x , y , width , height);
        UiBirds.setColor(Color.BLACK);
        UiBirds.fillOval(x+70 , y+20 , 10 , 10);
        UiBirds.drawLine(x+20 , y+20 , x+40 , y+30);
        UiBirds.drawLine(x+20 , y+30 , x+40 , y+20);*/
        ImageIcon BirdIcon = new ImageIcon(getClass().getClassLoader().getResource("images/bird.gif"));
        Image BirdImage = BirdIcon.getImage();
        UiBirds.drawImage(BirdImage, x, y, width, height, null);

        //UiBirds.fillOval(x , y-yT , 10 , 10);
    }

    public void moveBirds(int gameWidth, int gameHeight, int GunHeight){
        x += xSpeed;
        y += ySpeed;
        //yT = yT + 1;
        if(x + width > gameWidth)
            xSpeed *= -1;

        if(y + height > gameHeight - GunHeight - 50)
            ySpeed *= -1;

        if(x < 0)
            xSpeed *= -1;

        if(y < 50)
            ySpeed *= -1;
    }

    public Rectangle getBound() {
        Rectangle BirdRect = new Rectangle(x, y, width, height);
        return BirdRect;
    }

    public void Speed(int xspeed, int yspeed) {
        xSpeed = xspeed;
        ySpeed = yspeed;
    }

}
