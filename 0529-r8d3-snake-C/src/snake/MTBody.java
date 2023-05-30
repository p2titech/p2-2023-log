package snake;

import draw.Canvas;

// the empty (tail) of the body nodes of a snake
public class MTBody implements IBody {
	MTBody(){
	}
	@Override
	public IBody update(Position position) {
		return new MTBody();
	}
	@Override
	public boolean isAt(Position position) {
		return false;
	}
	@Override
	public boolean draw(Canvas c, SnakeWorld g) {
		return true;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}
}
