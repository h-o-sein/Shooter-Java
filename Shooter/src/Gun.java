import java.awt.*;

public class Gun {

    private int x;
    private int y;
    private int Width;
    private int Height;

    private int xSpeed;
    private int ySpeed;

    private int yFire;
    private boolean Fire = false;
    private Game game;

    public Gun(int x,int y,int Width, int Height) {

        super();
        this.x = x;
        this.y = y;
        this.Height = Height;
        this.Width = Width;
        this.xSpeed = 5;
        this.ySpeed = 5;
        this.yFire = y;

    }

    public void Drawing(Graphics ui) {

        ui.setColor(Color.ORANGE);
        ui.fillOval((x/2) - (Width/2), yFire, 24, 24);

        ui.setColor(Color.darkGray);
        ui.fill3DRect((x/2) - (Width/2), y - Height, Width, Height,true);

        ui.setColor(Color.red);
        ui.drawLine((x/2) + 5 - (Width) ,y - (4 * Height), (x/2) + 5 - (Width/2), y - (4 * Height));
        ui.drawLine((x/2) - 5 + (Width),y - (4 * Height), (x/2) - 5 + (Width/2), y - (4 * Height));

        ui.drawLine( x/2,(y + 7) - (4 * Height), x/2, (y + 7) - (4 * Height) + 11);
        ui.drawLine( x/2,(y - 7) - (4 * Height), x/2, (y - 7) - (4 * Height) - 11);

    }

    public void MoveLeftGun() {

        if (x <= Width)
            x = Width;
        else {
            xSpeed = -15;
            x += xSpeed;
        }

    }

    public void MoveRightGun(int gameWidth) {

        if (x + Width < 2*gameWidth) {
            xSpeed = 15;
            x += xSpeed;
        } else
            x = 2*gameWidth - Width;

    }

    public void FireGun(int gameHeight) {
        if (yFire > -25) {
            ySpeed = 25;
            yFire -= ySpeed;
        }
        else {
            yFire = gameHeight - 24;
        }
    }

}
