package snake;

import colors.*;
import draw.*;

// an apple to be eaten by the snake
public class Apple implements IPosComp{
	Position pos;
	IColor COLOR = new Red();

	public Apple(Position pos) {
		super();
		this.pos = pos;
	}

	public Apple(int width, int height) {
		this.pos = new Position(this.random(width), this.random(height));
	}

	private int random(int max) {
		return (int) (Math.random()*max);
	}

	// to draw this apple on canvas c by using parameters in g
	public boolean draw(Canvas c, SnakeWorld g) {
		Position center = 
				this.pos.scale(g.cellSize()).add(g.oneHalfCell()); 
		return c.drawDisk(center, g.cellSize()/2, this.COLOR);
	}

	// to determine whether this apple is at the given p
	public boolean isAt(Position p) {
		return this.pos.equals(p);
	}

}
