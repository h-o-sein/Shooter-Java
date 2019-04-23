import java.awt.Color;
import java.awt.Graphics;

public class Board {

	private int x;
	private int y;

	private int xSpeed;

	private int width;
	private int height;

	private Color color;

	public Board(int x, int y, int width, int height, Color color) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
		this.xSpeed = 5;
	}

	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}

	public void moveLeft() {
		if (x <= 0)
			x = 0;
		else {
			xSpeed = -5;
			x += xSpeed;
		}

	}

	public void moveRight(int gameWidth) {
		if (x + width < gameWidth) {
			xSpeed = 5;
			x += xSpeed;
		} else
			x = gameWidth - width;

	}

}
