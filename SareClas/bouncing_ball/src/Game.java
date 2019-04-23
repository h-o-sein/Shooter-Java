import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;


public class Game extends JPanel implements ActionListener, KeyListener {
	
	private ArrayList<Ball> balls;
	private Board board;
	private Timer timer;
	
	public static final int WIDTH = 300;
	public static final int HEIGHT = 500;
	
	public Game() {
		timer = new Timer(20, this);
		timer.start();
		
		this.addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(true);
		
		balls = new ArrayList<Ball>();
		
		balls.add(new Ball(35, 180, 30, Color.BLUE));
		balls.add(new Ball(70, 80, 50, Color.RED));
		balls.add(new Ball(35, 300, 20, Color.GREEN));
		balls.add(new Ball(100, 40, 80, Color.YELLOW));
		balls.add(new Ball(90, 90, 15, Color.BLACK));
		balls.add(new Ball(10, 200, 75, Color.MAGENTA));
		
		board = new Board(100, 400, 100, 15, Color.ORANGE);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		/*Ball ball1 = new Ball(35, 180, 30, Color.BLUE);
		ball1.draw(g);
		
		Ball ball2 = new Ball(125, 80, 60, Color.RED);
		ball2.draw(g);*/	
		
		
		for(Ball ball : balls)
			ball.draw(g);
				
		board.draw(g);
				
				
			
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(Ball ball : balls)
			ball.move(WIDTH, HEIGHT);
		
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		//System.out.println("one of keys was typed...");		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//System.out.println("one of keys was pressed...");
		//System.out.println(e.getKeyCode());
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
			board.moveLeft();
			//System.out.println("Left Key");
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			board.moveRight(WIDTH);
			//System.out.println("Right Key");
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//System.out.println("one of keys was released...");		
	}

}
