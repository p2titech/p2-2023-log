package snake;

import draw.Canvas;
import geometry.Posn;

//蛇の胴体部分の体節リスト
public interface ISnakeBody {

	// リストが空か
	public boolean isEmpty();

	// リスト末尾の体節を削除
	public ISnakeBody removeTailUnit();

	// 蛇の胴体部分の描画
	public boolean draw(Canvas c);

	public boolean collisionBody2(Posn head);

}
