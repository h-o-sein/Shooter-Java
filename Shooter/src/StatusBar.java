import java.awt.*;

public class StatusBar {

    private int width;
    private int height;
    private int x;
    private int y;
    private Color color;

    private int FireCount;

    public StatusBar(int x, int y, int width, int height, Color color) {

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;

        this.FireCount = 0;

    }


    public void draw(Graphics UIStatusBar) {

        UIStatusBar.setColor(color);
        UIStatusBar.fillRect(x, y, width, height);
        int Fire = 10 - FireCount;
        UIStatusBar.setColor(Color.RED);
        UIStatusBar.drawString("Shots: " + String.valueOf(Fire), (width)/2 - 25, height/2);

    }

    public void StatusFire() {
        FireCount++;
    }


}
