package block;
import colors.IColor;
import draw.Canvas;

// a block added to a group of blocks
class ConsBlocks extends ABlocks {
	DrpBlock fst;
	IBlocks rst;
	public ConsBlocks(DrpBlock fst, IBlocks rst) {
		super();
		this.fst = fst;
		this.rst = rst;
	}
	
	@Override
	public boolean overlap(IBlocks those) {
		return this.fst.overlap(those)
				|| this.rst.overlap(those);
	}

	@Override
	public IBlocks append(IBlocks those) {
		return new ConsBlocks(this.fst, this.rst.append(those));
	}

	@Override
	public boolean draw(Canvas canvas, IColor color, int cell_size) {
		return this.fst.draw(canvas, color, cell_size) &&
				this.rst.draw(canvas, color, cell_size);
	}

	@Override
	public IBlocks move(int dd, int dr) {
		return new ConsBlocks(this.fst.move(dd,dr), this.rst.move(dd,dr));
	}

	@Override
	public boolean hasAnyBlockAt(DrpBlock that) {
		return this.fst.equals(that) 
				|| this.rst.hasAnyBlockAt(that);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fst == null) ? 0 : fst.hashCode());
		result = prime * result + ((rst == null) ? 0 : rst.hashCode());
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
		ConsBlocks other = (ConsBlocks) obj;
		if (fst == null) {
			if (other.fst != null)
				return false;
		} else if (!fst.equals(other.fst))
			return false;
		if (rst == null) {
			if (other.rst != null)
				return false;
		} else if (!rst.equals(other.rst))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ConsBlocks [fst=" + fst + ", rst=" + rst + "]";
	}

	
}
