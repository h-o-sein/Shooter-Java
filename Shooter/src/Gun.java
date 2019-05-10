import java.awt.*;

public class Gun {

    private int x;
    private int y;
    private int Width;
    private int Height;

    private int xSpeed;

    public Gun(int x,int y,int Width, int Height) {

        super();
        this.x = x;
        this.y = y;
        this.Height = Height;
        this.Width = Width;
        this.xSpeed = 5;

    }

    public void Drawing(Graphics ui) {
        ui.setColor(Color.darkGray);
        ui.fill3DRect((x/2) - (Width/2), y - Height, Width, Height,true);

        ui.setColor(Color.red);
        ui.drawLine((x/2) + 5 - (Width) ,y - (4 * Height), (x/2) + 5 - (Width/2), y - (4 * Height));
        ui.drawLine((x/2) - 5 + (Width),y - (4 * Height), (x/2) - 5 + (Width/2), y - (4 * Height));

        ui.drawLine( x/2,(y + 7) - (4 * Height), x/2, (y + 7) - (4 * Height) + 11);
        ui.drawLine( x/2,(y - 7) - (4 * Height), x/2, (y - 7) - (4 * Height) - 11);

    }

    public void MoveLeftGun() {

        if (x <= 0)
            x = 0;
        else {
            xSpeed = -10;
            x += xSpeed;
        }

    }

    public void MoveRightGun(int gameWidth) {

        if (x + Width < gameWidth) {
            xSpeed = 10;
            x += xSpeed;
        } else
            x = gameWidth - Width;

    }

}
