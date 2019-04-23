import java.awt.Color;
import java.awt.Graphics;

public class Birds {

    private int x;
    private int y;

    private int xSpeed;
    private int ySpeed;

    private Color color;
    private int width;
    private int height;


    public void Ball(int x, int y, int width,int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;

        xSpeed = 1;
        ySpeed = 1;
    }


    public void draw(Graphics g){
        g.setColor(color);
        g.fillOval(x , y , width , height);
    }

    public void move(int gameWidth, int gameHeight){
        x += xSpeed;
        y += ySpeed;

        if(x + width > gameWidth)
            xSpeed *= -1;

        if(y + height > gameHeight)
            ySpeed *= -1;

        if(x < 0)
            xSpeed *= -1;

        if(y < 0)
            ySpeed *= -1;
    }
}
