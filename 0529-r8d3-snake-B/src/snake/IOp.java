package snake;

// an object of a method that combines two values into one
public interface IOp<ITEM, RESULT> {
	RESULT combine(ITEM x, RESULT y);
}
