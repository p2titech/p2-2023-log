package snake;

import colors.*;
import draw.*;
import geometry.*;

// the world of the snake game
public class SnakeWorld extends World{
	Snake s;
	IList<Apple> apples;
	int HEIGHT = 10; //cells
	int WIDTH = 10;  //cells
	int CELL_PX = 30; // pixels
	IColor BACK_COLOR = new LightGray();
	IColor WALL_COLOR = new Blue();

	public SnakeWorld(Snake h, IList<Apple> apples) {
		super();
		this.s = h;
		this.apples = apples;
	}

	//to compute the updated state of this game state
	public SnakeWorld update() {
		return new SnakeWorld(this.s.update(), this.apples);
	}
	
	public World onTick() {
		if(this.s.isOnBody()||this.isOnWall()) {
			return this.endOfWorld("Game_Over");
		}else {
			Snake s1 = s.update();
			if (s1.isOnApple(this.apples)) {
				return new SnakeWorld(
						s.grow(), 
						new Cons<Apple>(
								new Apple(this.WIDTH,this.HEIGHT),
								this.apples.removeAt(s1.headPos())));
			} else {
				return this.update();
			}
		}
	}
	
	public World onKeyEvent(String key) {
		return new SnakeWorld(this.s.move(key), this.apples);
	}
	
	//to draw this game scene on the given canvas c
	public boolean drawOn(Canvas c) {
		return c.drawRect(new Posn(0,0), this.getWidthPX(), this.getHeightPX(), 
				this.WALL_COLOR) &&
			c.drawRect(new Posn(this.CELL_PX,this.CELL_PX), 
					this.CELL_PX * this.WIDTH, this.CELL_PX* this.HEIGHT, 
					this.BACK_COLOR) &&
			this.s.draw(c, this) &&
			this.apples.draw(c,this);
	}
	
	public boolean draw() {
		return drawOn(theCanvas);
	}

	// to compute the width of the game in pixels
	public int getWidthPX() {
		return (this.WIDTH+2)*this.CELL_PX;
	}
	// to compute the height of the game in pixels
	public int getHeightPX() {
		return (this.HEIGHT+2)*this.CELL_PX;
	}
	//
	public int cellSize() {
		return this.CELL_PX;
	}

	// to compute a vector from the top-left corner to the center of a cell
	public Position oneHalfCell() {
		return new Position(this.CELL_PX*3/2, this.CELL_PX*3/2);
	}

	//to determine if the head of snake is outside canvas 
			public boolean isOnWall() {
				int x = this.s.pos.getX();
				int y = this.s.pos.getY();
				return x>=this.WIDTH||x<0||y>=this.HEIGHT||y<0;
			}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apples == null) ? 0 : apples.hashCode());
		result = prime * result + ((s == null) ? 0 : s.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SnakeWorld other = (SnakeWorld) obj;
		if (apples == null) {
			if (other.apples != null)
				return false;
		} else if (!apples.equals(other.apples))
			return false;
		if (s == null) {
			if (other.s != null)
				return false;
		} else if (!s.equals(other.s))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SnakeGame [h=" + s + ", apples=" + apples + "]";
	}

}
