import javax.swing.*;
import java.awt.*;

public class Game extends JPanel {

    public static final int WIDTH = 450;
    public static final int HEIGHT = 650;

    private Gun gun;

    public Game() {

        setFocusable(true);
        setFocusTraversalKeysEnabled(true);

        gun = new Gun(WIDTH, HEIGHT,20,100);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        gun.Drawing(g);

    }
}
