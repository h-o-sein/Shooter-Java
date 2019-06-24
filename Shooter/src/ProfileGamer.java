import javax.swing.*;

public class ProfileGamer {

    private String Name;
    private JFrame Frame;

    public void DialogName() {

        Frame = new JFrame();
        Name = JOptionPane.showInputDialog(Frame,"Enter Your Name :");

    }

}
