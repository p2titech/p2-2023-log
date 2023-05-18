package snake;

import java.util.Objects;

import colors.*;
import draw.*;
import geometry.*;

// the world of the snake game
public class SnakeWorld extends World{
	
	Snake snake;
	IApples apples;
	int height = 10; //縦方向マスの数。今は固定
	int width = 10; //横方向マスの数。今は固定
	IColor backgroundColor = new DarkGray();
	IColor wallColor = new Blue();
	
	public SnakeWorld(Snake snake, IApples apples) {
		this.snake = snake;
	}
	boolean draw(Canvas c) {
		//this.snake
		//this.height
		//this.width
		//this.cackgroundcolor
		//this.wallcolor
		return
		c.drawRect(new Posn(0,0),360,360,this.wallColor)&&
		c.drawRect(new Posn(30,30),300,300, backgroundColor) && 
		this.snake.draw(c);
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
		return Objects.equals(apples, other.apples) && Objects.equals(backgroundColor, other.backgroundColor)
				&& height == other.height && Objects.equals(snake, other.snake)
				&& Objects.equals(wallColor, other.wallColor) && width == other.width;
	}
	
	public World onTick() {
		if (this.collisionWall()||this.snake.collisionBody()) {
			return this.endOfWorld("GAME OVER");
		} else {
			return new SnakeWorld(this.snake.move(), this.apples);
		}
	}
	
	public World onKeyEvent(String key) {
		return this;
	}
	
	public boolean draw() {
		return draw(theCanvas);
	}
	
	public boolean collisionWall() {
		int x =  this.snake.headLocation.x;
		int y = this.snake.headLocation.y;
		return x < 0 || x > this.width || y < 0 || y > this.height;
	}
	


}
