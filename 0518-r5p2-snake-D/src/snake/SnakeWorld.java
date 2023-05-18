package snake;

import java.util.Objects;

import colors.*;
import draw.*;
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
	@Override
	public World onTick() {
		if(this.snake.collisionWall(this.width,this.height)) {
			return endOfWorld("GAME OVER");
		} else if(this.snake.collisionBody()) {
			return endOfWorld("GAME OVER");
		}
		return new SnakeWorld(this.snake.move(), this.apples);
	}
	@Override
	public World onKeyEvent(String key) {
		// TODO Auto-generated method stub
		if(key=="LEFT") {
			return new SnakeWorld(this.snake.setDirection(new DirLeft()), this.apples);
		}
        if(key=="UP") {
        	return new SnakeWorld(this.snake.setDirection(new DirUp()), this.apples);
        }
        if(key=="RIGHT") {
        	return new SnakeWorld(this.snake.setDirection(new DirRight()), this.apples);
        }
        if(key=="DOWN") {
        	return new SnakeWorld(this.snake.setDirection(new DirDown()), this.apples);
        }
        return this;
	}
	@Override
	public boolean draw() {
		return this.draw(this.theCanvas);
	}


}
