import java.awt.*;

public class StatusBar {

    private int width;
    private int height;
    private int status_height;
    private int x;
    private int y;
    private Color color;
    private Game game;

    private int FireCount;
    private int Scores;
    private String Name;
    private int Level;

    public StatusBar(int x, int y, int width, int height , int status_height , Color color) {

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.status_height = status_height ;

        this.FireCount = 0;

    }


    public void draw(Graphics UIStatusBar) {

        UIStatusBar.setColor(Color.darkGray);
        UIStatusBar.fillRect(0, game.HEIGHT, 450 , status_height - game.HEIGHT  );

        UIStatusBar.setColor(Color.WHITE);
        UIStatusBar.drawRect(10, game.HEIGHT + 10, width - 20, status_height - game.HEIGHT - 20);

        int Fire = 10 - FireCount;
        UIStatusBar.setColor(Color.yellow);
        UIStatusBar.setFont(new Font (Font.SANS_SERIF , Font.BOLD , 20));
        UIStatusBar.drawString("Shots: " + String.valueOf(Fire), 20 , game.HEIGHT + 30 ) ;
        UIStatusBar.drawString("Level: " , 220 , game.HEIGHT + 30 ) ;
       UIStatusBar.drawString("Scores: " + String.valueOf(Scores), 20 , game.HEIGHT + 80 ) ;

       UIStatusBar.drawString("Name: " + Name, 20 , game.HEIGHT + 130 ) ;
    }


    public void StatusFire() {
        FireCount++;
    }

    public void StatusScores(int Score) {
        Scores = Score;
    }

    public void StatusName(String name) {
        Name = name;
    }

    public void StatusLevel(int level) {
        Level = level;
    }

}
