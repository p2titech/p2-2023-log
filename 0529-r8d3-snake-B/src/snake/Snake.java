package snake;
import colors.*;
import draw.Canvas;

// a snake that has a head and a body
public class Snake {
	Position pos;
	Position direction;
	IBody body;
	
	IColor COLOR     = new Yellow();
	IColor EYE_COLOR = new Red();
	Position NORTH = new Position( 0,-1);
	Position WEST  = new Position(-1, 0);
	Position SOUTH = new Position( 0, 1);
	Position EAST  = new Position( 1, 0);
	
	public Snake(Position pos, Position direction, IBody body) {
		super();
		this.pos = pos;
		this.direction = direction;
		this.body = body;
	}
	
	// to determine snake direction according to key
	public Snake move(String key) {
		if     (key.equals("LEFT")) {
			return new Snake(this.pos, WEST, this.body);
		}
		else if(key.equals("RIGHT")) {
			return new Snake(this.pos, EAST, this.body);
		}
		else if(key.equals("UP")) {
			return new Snake(this.pos, NORTH, this.body);
		}
		else if(key.equals("DOWN")) {
			return new Snake(this.pos, SOUTH, this.body);
		}
		else {
			return this;
		}
	}
	
	//to compute the snake at the updated position from this position
	public Snake update() {
		return new Snake(
				this.pos.add(this.direction), 
				this.direction, 
				this.body.update(this.pos));
	}

	//to compute the snake moving its head one step ahead with growing 
	//its body node by one
	public Snake grow() {
		return new Snake(
				this.pos.add(this.direction), 
				this.direction, 
				new ConsBody(new Node(this.pos), this.body));
	}

	//to determine if the head of this snake is on one of its body node
	public boolean isOnBody() {
		return this.body.isAt(this.pos);
	}
	
	//to determine whether its head is on one of the given apples
	public boolean isOnApple(IApples apples) {
		return apples.isAt(this.pos);
	}
	
	//to return the position of its head
	public Position headPos() {
		return this.pos;
	}

	// to draw this snake on the given canvas c
	public boolean draw(Canvas c, SnakeWorld g) {
		Position center = this.pos.scale(g.cellSize()).add(g.oneHalfCell()); 
		return // body 
				this.body.draw(c,g) && 
				// head
				c.drawDisk(center, g.cellSize()/2, this.COLOR) &&
				// and tongue
				c.drawDisk(center.add(this.direction.scale(g.cellSize()*4/10)), 
						g.cellSize()/6, this.EYE_COLOR);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((body == null) ? 0 : body.hashCode());
		result = prime * result + ((direction == null) ? 0 : direction.hashCode());
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
		Snake other = (Snake) obj;
		if (body == null) {
			if (other.body != null)
				return false;
		} else if (!body.equals(other.body))
			return false;
		if (direction == null) {
			if (other.direction != null)
				return false;
		} else if (!direction.equals(other.direction))
			return false;
		if (pos == null) {
			if (other.pos != null)
				return false;
		} else if (!pos.equals(other.pos))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Head [pos=" + pos + ", direction=" + direction + ", body=" + body + "]";
	}




}
