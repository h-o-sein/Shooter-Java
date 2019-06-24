import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main extends JFrame {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Shooter Game");

        Game game = new Game();
        game.setPreferredSize(new Dimension(game.WIDTH,game.STATUS_HEIGHT));
        frame.add(game);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);


    }}


  /*  private JButton buttonLeft;

    public Main(){
        super();

        setLayout(new FlowLayout());

        buttonLeft = new JButton("Left");
        add(buttonLeft);

        buttonLeft.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


    }


}
*/
/*
class DrawPanel extends JPanel {


    protected void paintComponent(Graphics ui) {
        super.paintComponent(ui);

        setBackground(Color.WHITE);

        ui.setColor(Color.RED);
        ui.fillRect(10,25,20,100);
    }
}*/


