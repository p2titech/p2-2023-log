package snake;

import geometry.*;

import java.util.Objects;

import colors.*;
import draw.Canvas;

// a snake
public class Snake {
	Posn headLocation; //頭の位置
	ISnakeBody body;
	IDirection dir; //蛇の頭が向いている方向
	IColor headColor = new Cyan();
	
	public Snake(Posn headLocation, ISnakeBody body, IDirection dir) {
		this.headLocation = headLocation;
		this.body = body;
		this.dir = dir;
	}

	//蛇を１ステップ分移動する。
	/*
	 * 今回は、胴体の体節リストの先頭に、直前まで頭のあった位置にある体節を1つ追加し、
	 * それから胴体の体節リストの末尾を削除する方法をとっている。 
	 */
	public Snake move() {
		
		Posn newHeadLocation = new Posn(
				this.dir.dirToPosn().getX()+this.headLocation.getX(),
				this.dir.dirToPosn().getY()+this.headLocation.getY());

		ISnakeBody newBody = new ConsSnakeBody(new BodyUnit(this.headLocation), this.body);
		
		return new Snake(
				newHeadLocation,
				newBody.removeTailUnit(),
				this.dir
				);
	}
	
	//蛇の描画：簡単のため描画サイズ固定
	public boolean draw(Canvas c) {
		return c.drawDisk(new Posn(this.headLocation.getX()*30 + 45, this.headLocation.getY()*30 + 45),15,this.headColor)
				&& this.body.draw(c);	
	}
	
	public boolean isStrikingSelf() {
		return this.body.existBody(headLocation);
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
		return Objects.equals(body, other.body) && Objects.equals(dir, other.dir)
				&& Objects.equals(headColor, other.headColor) && Objects.equals(headLocation, other.headLocation);
	}
	
	

	
}
