package block;
import colors.IColor;
import idraw.Canvas;

// a group of blocks
interface IBlocks {
	// to determine if this group is landed on the ground or on any block 
	// in those blocks 
	boolean landed(IBlocks those);

	// to determine if there are any pair of blocks in this group of blocks and 
	// the other group of blocks residing at the same position  
	boolean overlap(IBlocks other);

	// to determine if there is any block in this group that is at the position
	// of that block
	boolean hasAnyBlockAt(DrpBlock that);

	// to move this group of blocks downwards
	IBlocks down();

	// to shift this group of blocks by (dd,dr)
	IBlocks move(int dd, int dr);

	// to move this group of blocks by dR cells to the right if there is 
	// no fixed blocks at the new position
	IBlocks moveIfPossible(int dR, IBlocks fixed);

	// to append those blocks to this group of blocks
	IBlocks append(IBlocks those);

	// to draw this group of blocks on the given canvas with the given color
	void draw(Canvas canvas, IColor color, int cell_size);


}
