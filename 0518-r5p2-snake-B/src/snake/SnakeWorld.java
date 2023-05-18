package snake;

import java.util.Objects;

import colors.*;
import draw.Canvas;
import geometry.Posn;
import draw.World;

// the world of the snake game
public class SnakeWorld extends World {
	
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
	public boolean draw() {
		//this.snake
		//this.height
		//this.width
		//this.cackgroundcolor
		//this.wallcolor
		return
		theCanvas.drawRect(new Posn(0,0),360,360,this.wallColor)&&
		theCanvas.drawRect(new Posn(30,30),300,300, backgroundColor) && 
		this.snake.draw(theCanvas) && this.apples.draw(theCanvas);
	}
	public World onTick() {
		return new SnakeWorld(this.snake.move(),this.apples);
	}
	public World onKeyEvent(String key) {
		return new SnakeWorld(this.snake.change(key),this.apples);
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


}
