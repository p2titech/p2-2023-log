package block;

import idraw.*;
import colors.*;
import geometry.*;

//to represent the world of Tetris
class BlockWorld extends World {
	IBlocks falling;
	IBlocks fixed;
	IBlocks next;
	IBlocks third;
	int WIDTH = 11;
	int HEIGHT = 10;
	int CELL_SIZE = 30;
	IColor BACK_COLOR = new Black();
	IColor FALLING_COLOR = new Green();
	IColor FIXED_COLOR = new Blue();
	
	BlockWorld(IBlocks falling, IBlocks fixed, 
			IBlocks next, IBlocks third) {
		this.falling = falling;
		this.fixed = fixed;
		this.next = next;
		this.third = third;
	}

	BlockWorld() {
		this.falling = this.aVertialPiece();
		this.fixed = this.makeWall();
		this.next = this.aHorizontalPiece();
		this.third = this.aVertialPiece();
	}

	// to create walls around the world
	IBlocks makeWall() {
		return this.makeBlocks(0,0,this.HEIGHT,1,0)
				.append(this.makeBlocks(0,this.WIDTH-1,this.HEIGHT,1,0))
				.append(this.makeBlocks(this.HEIGHT-1,0,this.WIDTH,0,1));
	}

	// to create a sequence of n blocks, starting at (down,right)
	// and growing towards (dd,dr).
	IBlocks makeBlocks(int down, int right, int n, int dd, int dr) {
		if (n==0) 
			return new MTBlocks();
		else
			return new ConsBlocks(new DrpBlock(down, right), 
					this.makeBlocks(down+dd, right+dr, n-1, dd, dr));
	}

	// to create a vertical piece
	IBlocks aVertialPiece() {
		return this.makeBlocks(0, this.WIDTH/2, 3, 1, 0);
	}
	// to create a horizontal piece
	IBlocks aHorizontalPiece() {
		return this.makeBlocks(0, this.HEIGHT/2-1, 3, 0, 1);
	}
	
	public void onTick() {
		if (this.falling.landed(this.fixed)) { //TODO: implement this condition ************************
			
			// the falling piece is landed on another piece or the wall
			if (this.falling.overlap(this.next)) {
				// the next piece is overlapping this the falling (i.e., newly 
				// fixed) piece
				this.endOfWorld("Game Over");
				return;
			} else {
				// the next piece is still free
					this.fixed = this.fixed.append(this.falling);
					this.falling = this.next;
					this.next = this.third;
					this.third = this.falling;
					//TODO: implement this expression **************
					
					return;
			}
		} else {
			// the falling piece can fall
			 new BlockWorld(this.falling.down(), this.fixed,
					this.next, this.third);
			 return;
		}
	}

	public void onKeyEvent(String key) {
		if (key.equals("LEFT")) {
			this.falling = this.falling.moveIfPossible(-1, this.fixed) ;
		} else if (key.equals("RIGHT")) {
			this.falling = this.falling.moveIfPossible(+1,  this.fixed); 
		} else {
			 return;
		}
	}

	public void draw() {
		this.drawAll(this.theCanvas);
	}

	// to draw the background of the game screen
	void drawBackground(Canvas c) {
		c.drawRect(new Posn(0, 0), 
				this.getCanvasWidth(), this.getCanvasHeight(), BACK_COLOR);
	}

	// to draw all elements on the canvas c
	void drawAll(Canvas c) {
		this.drawBackground(c) ;
		this.falling.draw(c, this.FALLING_COLOR, this.CELL_SIZE);
		this.fixed.draw(c, this.FIXED_COLOR, this.CELL_SIZE);
	}

	// the width of the game in pixels
	int getCanvasWidth() {
		return this.WIDTH* this.CELL_SIZE;
	}
	// the height of the game in pixels
	int getCanvasHeight() {
		return this.HEIGHT * this.CELL_SIZE;
	}


}
