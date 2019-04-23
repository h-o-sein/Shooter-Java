import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel  {

    public static final int WIDTH = 450;
    public static final int HEIGHT = 650;

    private ArrayList<Birds> birdss;
    //private Timer timer;

    private Gun gun;
    private Birds birds;

    public Game() {
       // timer = new Timer(20, this);
        //timer.start();


        gun = new Gun(WIDTH, HEIGHT,25,100);

        birdss = new ArrayList<Birds>();
        birdss.add(new Birds (10,10,90,70,Color.orange));
        birdss.add(new Birds (10,10,90,70,Color.green));
        birdss.add(new Birds (10,10,90,70,Color.yellow));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        gun.Drawing(g);
        birds.draw(g);

    }

   /* @Override
    public void actionPerformed(ActionEvent e) {
        for(Birds birds : birdss)
            birds.move(WIDTH, HEIGHT);

        repaint();
    }
    */



}

