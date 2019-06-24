import java.awt.*;
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
    public static final int STATUS_HEIGHT = 800;

    //private ArrayList<Birds> birds;
    private ArrayList<Birds> birds = new ArrayList<Birds>();
    //private ArrayList<Bombs> bombs = new ArrayList<Bombs>();
    private Timer timer;
    private Gun gun;
    private ProfileGamer profileGamer;
    private StatusBar statusBar;
    private int GunHeight = 100;
    private int ShotCounter = 0;
    private int Scores = 0;
    private int Level = 0;

    public Game() {
        timer = new Timer(20,this);
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

      /*  for (Bombs bomb:bombs) {
            bomb.draw(g);
            if (bomb.getBound().intersects(gun.getBound())){
                bombs.remove(bomb);

            }
        }
        */
        for (Birds bird:birds) {
            bird.draw(g);
            if (bird.getBound().intersects(gun.getBound())){
                birds.remove(bird);
                Scores = Scores + 25;
                statusBar.StatusScores(Scores);
                CreateBirds(Scores);
            }
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
                statusBar.StatusFire();
                ShotCounter++;
            }
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
            statusBar.StatusLevel(Level);
        }
        else if (Scores == 100) {
            Level++;
            birds.add(new Birds(260,85,90,70,Color.orange));
            birds.add(new Birds(100,50,90,70,Color.green));
            birds.add(new Birds(50,200,90,70,Color.yellow));
            birds.add(new Birds(260,300,90,70,Color.BLUE));
            birds.add(new Birds(85,260,90,70,Color.BLUE));
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
            statusBar.StatusLevel(Level);
        }
        else if (Scores == 400) {

        }
    }


}

