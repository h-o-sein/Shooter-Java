import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.Timer;
import javax.swing.JPanel;

public class Game extends JPanel implements ActionListener, KeyListener {

    public static final int WIDTH = 450;
    public static final int HEIGHT = 650;

    private ArrayList<Birds> birds;
    private Timer timer;
    private Gun gun;

    public Game() {
        timer = new Timer(20,this);
        gun = new Gun(WIDTH, HEIGHT,25,100);

        birds = new ArrayList<Birds>();
        birds.add(new Birds(10,10,90,70,Color.orange));
        birds.add(new Birds(10,10,90,70,Color.green));
        birds.add(new Birds(10,10,90,70,Color.yellow));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Birds bird:birds)
            bird.draw(g);

        gun.Drawing(g);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Birds bird:birds)
            bird.moveBirds(WIDTH,HEIGHT);
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }



}

