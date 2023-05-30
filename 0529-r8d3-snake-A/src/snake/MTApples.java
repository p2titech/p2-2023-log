package snake;

import draw.Canvas;

// empty list of apples
public class MTApples implements IApples {

	@Override
	public boolean draw(Canvas c, SnakeWorld snakeWorld) {
		return true;
	}

	@Override
	public boolean isAt(Position pos) {
		return false;
	}

	@Override
	public IApples removeAt(Position position) {
		throw new RuntimeException("no apple is found");
	}

}
