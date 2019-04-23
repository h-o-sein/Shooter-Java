import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;


public class MainApp {

	public static void main(String[] args) {

		JFrame frame = new JFrame("Bouncing Ball");

		//JFrame frame = new JFrame();
		//frame.setTitle("Bouncing Ball");
		
		Game game = new Game();
		game.setPreferredSize(new Dimension(Game.WIDTH, Game.HEIGHT));
		frame.add(game);		
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

}
