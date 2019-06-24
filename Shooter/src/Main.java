import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Shooter Game");

        Game game = new Game();
        game.setPreferredSize(new Dimension(game.WIDTH,game.STATUS_HEIGHT));
        frame.add(game);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);


    }

}
