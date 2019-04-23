import java.awt.*;

public class Gun {

    private int x;
    private int y;
    private int Width;
    private int Height;

    public Gun(int x,int y,int Width, int Height) {

        this.x = x;
        this.y = y;
        this.Height = Height;
        this.Width = Width;

    }

    public void Drawing(Graphics ui) {
        ui.setColor(Color.darkGray);
        ui.fill3DRect((x/2) - (Width/2), y - Height, Width, Height,true);

        ui.setColor(Color.GREEN);
        //ui.drawLine();
    }

}
