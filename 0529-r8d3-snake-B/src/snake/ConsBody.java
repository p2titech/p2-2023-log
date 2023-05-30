package snake;

import draw.Canvas;

// a body node connected to the rest body nodes
public class ConsBody implements IBody {
	Node fst;
	IBody rst;
	public ConsBody(Node snake, IBody list) {
		super();
		this.fst = snake;
		this.rst = list;
	}
	@Override
	public IBody update(Position position) {
		return new ConsBody(this.fst.update(position),
				this.rst.update(this.fst.getPosition()));
				
	}
	
	@Override
	public boolean isAt(Position position) {
		return this.fst.isAt(position) || 
				this.rst.isAt(position);
	}

	@Override
	public boolean draw(Canvas c, SnakeWorld g) {
		return this.fst.draw(c,g) && this.rst.draw(c, g);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rst == null) ? 0 : rst.hashCode());
		result = prime * result + ((fst == null) ? 0 : fst.hashCode());
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
		ConsBody other = (ConsBody) obj;
		if (rst == null) {
			if (other.rst != null)
				return false;
		} else if (!rst.equals(other.rst))
			return false;
		if (fst == null) {
			if (other.fst != null)
				return false;
		} else if (!fst.equals(other.fst))
			return false;
		return true;
	}
}
