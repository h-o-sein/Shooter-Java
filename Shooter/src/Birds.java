import java.awt.*;

public class Birds {

    private int x;
    private int y;

    private int xSpeed;
    private int ySpeed;

    private Color color;
    private int width;
    private int height;


    public Birds(int x, int y, int width,int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;

        xSpeed = 2;
        ySpeed = 2;
    }


    public void draw(Graphics UiBirds){
        UiBirds.setColor(color);
        UiBirds.fillOval(x , y , width , height);
        UiBirds.setColor(Color.BLACK);
        UiBirds.fillOval(x+70 , y+20 , 10 , 10);
        UiBirds.drawLine(x+20 , y+20 , x+40 , y+30);
        UiBirds.drawLine(x+20 , y+30 , x+40 , y+20);

    }

    public void moveBirds(int gameWidth, int gameHeight, int GunHeight){
        x += xSpeed;
        y += ySpeed;

        if(x + width > gameWidth)
            xSpeed *= -1;

        if(y + height > gameHeight - GunHeight - 50)
            ySpeed *= -1;

        if(x < 0)
            xSpeed *= -1;

        if(y < 0)
            ySpeed *= -1;
    }
}
