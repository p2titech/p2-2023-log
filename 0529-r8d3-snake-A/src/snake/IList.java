package snake;

// a list of ITEMs
public interface IList<ITEM extends IPosComp> {
	
	// to let the given visitor v visit a list node 
	public <RESULT> RESULT traverse(IListVisitor<RESULT,ITEM> v);
	
	// to apply f.process on every element in this list, and form 
	// a list of the results
	public <RESULT  extends IPosComp> IList<RESULT> map(IFun<ITEM,RESULT> f);
	
	// to fold up elements in this list by applying f.combine 
	public <RESULT> RESULT fold(IOp<ITEM,RESULT> f, RESULT e);
	boolean isAt(Position pos);
	boolean removeAt(Position position);
}
