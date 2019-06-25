import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.*;

public class Game extends JPanel implements ActionListener, KeyListener {

    public static final int WIDTH = 450;
    public static final int HEIGHT = 650;
    public static final int STATUS_HEIGHT = 800;

    //private ArrayList<Birds> birds;
    private ArrayList<Birds> birds = new ArrayList<Birds>();
    private Timer timer;
    private Gun gun;
    private ProfileGamer profileGamer;
    private StatusBar statusBar;
    private Birds sbirds;
    private int GunHeight = 100;
    private int ShotCounter = 1;
    private int Scores = 0;
    private int Level = 0;
    private boolean Losser = false;
    private boolean Restart = false;
    private int SpeedGame = 20;

    public Game() {
        timer = new Timer(SpeedGame,this);
        gun = new Gun(WIDTH, HEIGHT,25,GunHeight);
        profileGamer = new ProfileGamer();

        profileGamer.DialogName();


        timer.start();

        this.addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(true);

        statusBar = new StatusBar(0,0, WIDTH, 50, STATUS_HEIGHT, Color.lightGray);

        statusBar.StatusName(profileGamer.getName());
        statusBar.StatusLevel(Level);



        /*birds.add(new Birds(260,85,90,70,Color.orange));
        birds.add(new Birds(100,50,90,70,Color.green));
        birds.add(new Birds(50,200,90,70,Color.yellow));
        birds.add(new Birds(260,300,90,70,Color.BLUE));*/
        //ok
        CreateBirds(Scores);




    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Birds bird:birds) {
            bird.draw(g);
            if (bird.getBound().intersects(gun.getBound())){
                birds.remove(bird);
                Scores = Scores + 25;
                statusBar.StatusScores(Scores);
                CreateBirds(Scores);
            }
            if (Restart == true) {
                birds.remove(bird);
            }
        }
        Restart = false;



        if (Losser == true) {
            ImageIcon LossIcon = new ImageIcon(getClass().getClassLoader().getResource("images/loss.gif"));
            Image LossImage = LossIcon.getImage();
            g.drawImage(LossImage,120, HEIGHT/3, 200,100,null);

            ImageIcon LosserIcon = new ImageIcon(getClass().getClassLoader().getResource("images/losser.gif"));
            Image LosserImage = LosserIcon.getImage();
            g.drawImage(LosserImage,170, HEIGHT/5, 100,100,null);

            g.drawString("Restart Game Enter 'Z'",155,HEIGHT/2);
        }


        if (Scores >= 400) {
            ImageIcon WinnerIcon = new ImageIcon(getClass().getClassLoader().getResource("images/winner.gif"));
            Image WinnerImage = WinnerIcon.getImage();
            g.drawImage(WinnerImage,120, HEIGHT/3, 200,100,null);

            ImageIcon WinIcon = new ImageIcon(getClass().getClassLoader().getResource("images/win.gif"));
            Image WinImage = WinIcon.getImage();
            g.drawImage(WinImage,170, HEIGHT/5, 100,100,null);

            ImageIcon StarIcon = new ImageIcon(getClass().getClassLoader().getResource("images/star.gif"));
            Image StarImage = StarIcon.getImage();
            g.drawImage(StarImage,WIDTH/4, HEIGHT/9, 100,100,null);

            g.drawString("Restart Game Enter 'Z'",155,HEIGHT/2);
        }

        gun.Drawing(g);
        statusBar.draw(g);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Birds bird:birds)
            bird.moveBirds(WIDTH,HEIGHT,GunHeight);

        if (gun.Fire == true)
            gun.FireGun(HEIGHT);

        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            gun.MoveLeftGun();

        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            gun.MoveRightGun(WIDTH);

        if (e.getKeyCode() == KeyEvent.VK_SPACE) {

            if (ShotCounter < 10) {
                gun.Fire = true;
                statusBar.StatusFire(false,1);
                ShotCounter++;
            }
            else {
                Losser = true;
                statusBar.StatusFire(true,1);

            }
        }

        if (e.getKeyCode() == KeyEvent.VK_Z) {
            Restart = true;
            Losser = false;
            ShotCounter = 1;
            Level = 0;
            Scores = 0;
            statusBar.StatusScores(Scores);
            statusBar.StatusLevel(Level);
            statusBar.StatusFire(true,ShotCounter);
            CreateBirds(Scores);
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void CreateBirds(int scores) {


        if (Scores == 0) {
            Level++;
            birds.add(new Birds(260,85,90,70,Color.orange));
            statusBar.StatusLevel(Level);
        }
        else if (Scores == 25) {
            Level++;
            birds.add(new Birds(100,50,90,70,Color.green));
            birds.add(new Birds(50,200,90,70,Color.yellow));
            birds.add(new Birds(260,300,90,70,Color.BLUE));
            sbirds.Speed(5,5);
            SpeedGame = 25;
            statusBar.StatusLevel(Level);
        }
        else if (Scores == 100) {
            Level++;
            birds.add(new Birds(260,85,90,70,Color.orange));
            birds.add(new Birds(100,50,90,70,Color.green));
            birds.add(new Birds(50,200,90,70,Color.yellow));
            birds.add(new Birds(260,300,90,70,Color.BLUE));
            birds.add(new Birds(85,260,90,70,Color.BLUE));
            sbirds.Speed(10,10);
            SpeedGame = 35;
            statusBar.StatusLevel(Level);
        }
        else if (Scores == 225) {
            Level++;
            birds.add(new Birds(260,85,90,70,Color.orange));
            birds.add(new Birds(100,50,90,70,Color.green));
            birds.add(new Birds(50,200,90,70,Color.yellow));
            birds.add(new Birds(260,300,90,70,Color.BLUE));
            birds.add(new Birds(85,260,90,70,Color.BLUE));
            birds.add(new Birds(50,100,90,70,Color.green));
            birds.add(new Birds(150,10,90,70,Color.yellow));
            sbirds.Speed(20,20);
            SpeedGame = 45;
            statusBar.StatusLevel(Level);
        }
    }


}

