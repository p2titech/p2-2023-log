package block;
import colors.IColor;
import draw.Canvas;

// an empty group of blocks 
class MTBlocks implements IBlocks {

	@Override
	public IBlocks down() {
		return this;
	}

	@Override
	public boolean landed(IBlocks those) {
		return false;
	}

	@Override
	public IBlocks append(IBlocks those) {
		return those;
	}

	@Override
	public IBlocks move(int dR, int dR2) {
		return this;
	}

	@Override
	public boolean draw(Canvas theCanvas, IColor falling_COLOR, int cell_size) {
		return true;
	}

	@Override
	public boolean hasAnyBlockAt(DrpBlock that) {
		return false;
	}

	@Override
	public IBlocks moveIfPossible(int dR, IBlocks fixed) {
		return this;
	}

	@Override
	public boolean overlap(IBlocks fixed) {
		return false;
	}

}
