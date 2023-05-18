package snake;
import geometry.*;

//蛇の進行方向
public interface IDirection {
	//進行方向に対応する移動量を計算
	public Posn dirToPosn();
	
	//the opposite direction of this:true; else: false
	public boolean isOpposite(IDirection d);
}
