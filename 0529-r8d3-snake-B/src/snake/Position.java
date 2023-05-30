package snake;

import geometry.Posn;

// a position on a game screen (unit: number of cells)
public class Position extends Posn{
	public Position(int x, int y) {
		super(x,y);
	}
	
	// to add that position to this position
	Position add(Position that) {
		return new Position(this.x + that.x, this.y + that.y);
	}

	public Position scale(int factor) {
		return new Position(this.x*factor, this.y*factor);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
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
		Position other = (Position) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Position [x=" + x + ", y=" + y + "]";
	}

}
