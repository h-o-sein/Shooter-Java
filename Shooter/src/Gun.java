import java.awt.*;

public class Gun {

    private int x;
    private int y;
    private int Width;
    private int Height;

    private int xSpeed;
    private int ySpeed;

    public Gun(int x,int y,int Width, int Height) {

        super();
        this.x = x;
        this.y = y;
        this.Height = Height;
        this.Width = Width;
        this.xSpeed = 5;
        this.ySpeed = 5;

    }

    public void Drawing(Graphics ui) {
        ui.setColor(Color.darkGray);
        ui.fill3DRect((x/2) - (Width/2), y - Height, Width, Height,true);

        ui.setColor(Color.red);
        ui.drawLine((x/2) + 5 - (Width) ,y - (4 * Height), (x/2) + 5 - (Width/2), y - (4 * Height));
        ui.drawLine((x/2) - 5 + (Width),y - (4 * Height), (x/2) - 5 + (Width/2), y - (4 * Height));

        ui.drawLine( x/2,(y + 7) - (4 * Height), x/2, (y + 7) - (4 * Height) + 11);
        ui.drawLine( x/2,(y - 7) - (4 * Height), x/2, (y - 7) - (4 * Height) - 11);

        ui.setColor(Color.ORANGE);
        ui.fillOval((x/2) - (Width/2), y - Height, 24, 24);

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
        if (y < gameHeight) {
            ySpeed = 30;
            y += ySpeed;
        }
        else
            y = gameHeight - 24;
    }

}
