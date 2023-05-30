package snake;
import colors.*;
import draw.Canvas;

// a body node of a snake
public class Node {
	Position pos;
	IColor COLOR = new Green();
	public Node(Position pos) {
		super();
		this.pos = pos;
	}

	// to move this snake node to the given position
	public Node update(Position position) {
		return new Node(position);
	}
	
	// to get the position of this snake node
	public Position getPosition() {
		return this.pos;
	}
	
	// to determine if this node is at the given position
	public boolean isAt(Position position) {
		return this.pos.equals(position);
	}

	// to draw this snake on the given canvas c
	public boolean draw(Canvas c, SnakeWorld g) {
		return c.drawDisk(this.pos.scale(g.cellSize()).add(g.oneHalfCell()), g.cellSize()/2, 
				this.COLOR);
				
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((COLOR == null) ? 0 : COLOR.hashCode());
		result = prime * result + ((pos == null) ? 0 : pos.hashCode());
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
		Node other = (Node) obj;
		if (COLOR == null) {
			if (other.COLOR != null)
				return false;
		} else if (!COLOR.equals(other.COLOR))
			return false;
		if (pos == null) {
			if (other.pos != null)
				return false;
		} else if (!pos.equals(other.pos))
			return false;
		return true;
	}

}
