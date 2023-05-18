package snake;

import java.util.Objects;

import draw.*;
import geometry.Posn;

//胴体１ユニットと、残りの胴体のリスト
public class ConsSnakeBody implements ISnakeBody {
	BodyUnit fst;
	ISnakeBody rst;
	
	public ConsSnakeBody(BodyUnit fst, ISnakeBody rst) {
		this.fst = fst;
		this.rst = rst;
	}

	// リストが空か
	public boolean isEmpty() {
		return false;
	}
	
	// リスト末尾の体節を削除
	public ISnakeBody removeTailUnit() {
		if(this.rst.isEmpty()) {
			return new MTSnakeBody();
		} else {
			return new ConsSnakeBody(this.fst,this.rst.removeTailUnit());
		}
		
	}
	
	// 蛇の胴体部分の描画
	public boolean draw(Canvas c) {
		return this.fst.draw(c) && this.rst.draw(c);
	}
	
	public boolean existBody(Posn pos) {
		return (
				this.fst.location.equals(pos) ||
				this.rst.existBody(pos));
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConsSnakeBody other = (ConsSnakeBody) obj;
		return Objects.equals(fst, other.fst) && Objects.equals(rst, other.rst);
	}

}
