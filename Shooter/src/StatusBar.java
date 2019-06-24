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

       UIStatusBar.drawString("Scores: " + String.valueOf(Scores), 20 , game.HEIGHT + 80 ) ;

       UIStatusBar.drawString("Name: " , 20 , game.HEIGHT + 130 ) ;
    }

    // Score Panel
		/*g.setColor(Color.DARK_GRAY);
		g.fillRect(0, HEIGHT, WIDTH, PANEL_HEIGHT - HEIGHT);

		g.setColor(Color.WHITE);
		g.drawRect(10, HEIGHT + 10, WIDTH - 20, PANEL_HEIGHT - HEIGHT - 20);

		g.setColor(Color.YELLOW);
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD + Font.ITALIC, 16));
		g.drawString("Bouncing Ball", 20, HEIGHT + 40);

		g.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 12));
		g.drawString("Your Name is: " + name, 20, HEIGHT + 70);
		g.drawString("Your Score is: " + score, 20, HEIGHT + 100); */

    public void StatusFire() {
        FireCount++;
    }

    public void StatusScores(int Score) {
        Scores = Score;
    }


}
