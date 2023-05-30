package block;

import draw.*;
import geometry.*;
import colors.*;

//to represent a falling block
class DrpBlock {
	int down;
	int right;

	DrpBlock(int down, int right) {
		this.down = down;
		this.right = right;
	}

	// to drop this block
	void drop() {
//		return new DrpBlock(this.down + 1, this.right);
		this.down = this.down + 1;
	}

	// is this block landed on the ground?
	boolean landed(IBlocks those) {
		return those.hasAnyBlockAt(this);
	}

	// to shift this block's position by (dd,dr)
	void move(int dd, int dr) {
		//return new DrpBlock(this.down + dd, this.right + dr);
		this.down = this.down + dd;
		this.right = this.right + dr;
	}

	// to determine if there is any block in those blocks that is at the
	// same position with this block
	boolean overlap(IBlocks those) {
		return those.hasAnyBlockAt(this);
	}

	// to draw this block as a (cell_size x cell_size) rectangle on the given 
	// canvas with the given color
	boolean draw(Canvas canvas, IColor color, int cell_size) {
		return canvas.drawRect(new Posn(right * cell_size, down * cell_size), 
				cell_size-2, cell_size-2, color);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + down;
		result = prime * result + right;
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
		DrpBlock other = (DrpBlock) obj;
		if (down != other.down)
			return false;
		if (right != other.right)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DrpBlock [down=" + down + ", right=" + right + "]";
	}

}
