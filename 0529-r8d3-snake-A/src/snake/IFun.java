package snake;

// an object of a method that processes one value 
public interface IFun<ITEM, RESULT> {
	RESULT process(ITEM x);
}
