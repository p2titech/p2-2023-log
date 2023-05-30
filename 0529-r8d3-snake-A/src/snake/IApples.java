package snake;

import draw.Canvas;

// apples on the floor
public interface IApples {
	// to draw these apples on c
	boolean draw(Canvas c, SnakeWorld snakeWorld);

	// to determine whether any apple in this list is at the given pos
	boolean isAt(Position pos);

	// to remove the apple at the given position from this list 
	IApples removeAt(Position position);

}
