import java.awt.Color;
import java.awt.Graphics;


public class Ball {
	
	private int x;
	private int y;
	
	private int xSpeed;
	private int ySpeed;
	
	private int size;
	private Color color;
	
	public Ball(int x, int y, int size, Color color) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.color = color;
		
		xSpeed = 5;
		ySpeed = 2;
	}
	
	public void draw(Graphics g){
		g.setColor(color);
		g.fillOval(x, y, size, size);
	}
	
	
	public void move(int gameWidth, int gameHeight){		
		x += xSpeed;
		y += ySpeed;
		
		if(x + size > gameWidth)
			xSpeed *= -1;
		
		if(y + size > gameHeight)
			ySpeed *= -1;
		
		if(x < 0)
			xSpeed *= -1;
		
		if(y < 0)
			ySpeed *= -1;
	}
	
}
