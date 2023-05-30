package block;
// a group of blocks 
abstract class ABlocks implements IBlocks {

	@Override
	public boolean landed(IBlocks those) {
		return this.down().overlap(those);
	}

	@Override
	public IBlocks moveIfPossible(int deltaRight, IBlocks fixed) {
		if (this.move(0, deltaRight).overlap(fixed))
			// this block is moving to a position blocked by the fixed blocks
			return this;
		else
			return this.move(0, deltaRight);
	}

	@Override
	public IBlocks down() {
		return this.move(1, 0);
	}

}
