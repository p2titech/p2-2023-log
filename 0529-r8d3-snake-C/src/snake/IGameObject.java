package snake;
import draw.*;
import geometry.*;

public interface IGameObject {
	public boolean draw(Canvas c, SnakeWorld g);
	public boolean isAt(Position position);
}
