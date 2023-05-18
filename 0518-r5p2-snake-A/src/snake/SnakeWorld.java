package snake;

import java.util.Objects;

import colors.*;
import draw.Canvas;
import draw.World;
import geometry.Posn;

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
		this.apples = apples;
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
		this.snake.draw(c) &&
		this.apples.draw(c);
		
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
	@Override
	public World onTick() {
		// TODO Auto-generated method stub
		if (this.isStrikingWalls() || this.snake.isStrikingSelf())
			return this.endOfWorld("The head is broken!");
		return new SnakeWorld(this.snake.move(), this.apples);
	}
	@Override
	public World onKeyEvent(String key) {
		// TODO Auto-generated method stub
		if(key.equals("RIGHT")) {
			this.snake.dir=new DirRight();
		}
		else if(key.equals("LEFT")) {
			this.snake.dir=new DirLeft();
		}
		else if(key.equals("DOWN")) {
			this.snake.dir=new DirDown();
		}
		else if(key.equals("UP")) {
			this.snake.dir=new DirUp();
		}
		return this;
	}
	@Override
	public boolean draw() {
		// TODO Auto-generated method stub
		return this.draw(theCanvas);
	}
	
	// 壁に衝突しているかを判定する
	public boolean isStrikingWalls() {
		return (
				(this.snake.headLocation.getX() >= 10) ||
				(this.snake.headLocation.getX() <= -1) ||
				(this.snake.headLocation.getY() >= 10) ||
				(this.snake.headLocation.getY() <= -1)
				);
	}


}
