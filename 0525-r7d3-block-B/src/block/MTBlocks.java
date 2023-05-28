package block;
import colors.IColor;
import idraw.Canvas;

// an empty group of blocks 
class MTBlocks extends ABlocks implements IBlocks {

	@Override
	public void down() {
		return;
	}
	
	public ABlocks copy() {
		return new MTBlocks();
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
	public void move(int dR, int dR2) {
		return;
	}

	@Override
	public void draw(Canvas theCanvas, IColor falling_COLOR, int cell_size) {
		return;
	}

	@Override
	public boolean hasAnyBlockAt(DrpBlock that) {
		return false;
	}

	@Override
	public void moveIfPossible(int dR, IBlocks fixed) {
		return;
	}

	@Override
	public boolean overlap(IBlocks fixed) {
		return false;
	}

}
