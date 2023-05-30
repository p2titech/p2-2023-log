package snake;

import colors.*;
import draw.Canvas;

// an apple added to a list of apples
public class ConsApples implements IApples {
	Apple fst;
	IApples rst;
	IColor APPLE_COLOR = new Red();

	public ConsApples(Apple fst, IApples rst) {
		super();
		this.fst = fst;
		this.rst = rst;
	}

	@Override
	public boolean draw(Canvas c, SnakeWorld g) {
		return // the first one
				this.fst.draw(c, g) &&
				// and the rest
				this.rst.draw(c,g);
	}

	@Override
	public boolean isAt(Position pos) {
		return this.fst.isAt(pos) || this.rst.isAt(pos);
	}

	@Override
	public IApples removeAt(Position position) {
		if (this.fst.isAt(position))
			return this.rst;
		else
			return new ConsApples(this.fst, this.rst.removeAt(position));

	}
}
