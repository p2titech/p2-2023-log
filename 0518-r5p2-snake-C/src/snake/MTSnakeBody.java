package snake;

import draw.Canvas;
import geometry.Posn;

//空の体節リスト
public class MTSnakeBody implements ISnakeBody {
	
	// リストが空か
	public boolean isEmpty() {
		return true;
	}

	// リスト末尾の体節を削除
	public ISnakeBody removeTailUnit() {
		return this;
	}
	
	// 蛇の胴体部分の描画
	public boolean draw(Canvas c) {
		return true;
	}
	
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null) return false;
	    if (getClass() != obj.getClass()) return false;
	    return true;
	  }

	@Override
	public boolean collisionBody2(Posn head) {
		return false;
	}




}
