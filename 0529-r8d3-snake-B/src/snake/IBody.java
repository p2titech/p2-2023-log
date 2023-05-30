package snake;

import draw.Canvas;

// the body nodes of a snake
public interface IBody {
	// to move this snake body to the given position
	public IBody update(Position position);

	// to determine if any of these nodes at the given position
	public boolean isAt(Position position);

	// to draw this body of snake on canvas c
	public boolean draw(Canvas c, SnakeWorld g);
}
