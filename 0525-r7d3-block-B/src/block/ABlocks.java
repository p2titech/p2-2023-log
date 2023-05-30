package block;
// a group of blocks 
abstract class ABlocks implements IBlocks {

	@Override
	public boolean landed(IBlocks those) {
		ABlocks copy=this.copy();
		copy.down();
		return copy.overlap(those);
	}
	
	public abstract ABlocks copy();

	@Override
	public void moveIfPossible(int deltaRight, IBlocks fixed) {
		this.move(0, deltaRight);
		if (this.overlap(fixed)) {
			// this block is moving to a position blocked by the fixed blocks

			this.move(0, -deltaRight);
		}
	}

	@Override
	public void down() {
		this.move(1, 0);
	}

}
