package snake;

// a list with implementations of map and fold
public abstract class AList<ITEM extends IPosComp> implements IList<ITEM> {

	@Override
	abstract public <RESULT> RESULT traverse(IListVisitor<RESULT, ITEM> v);

	@Override
	public <RESULT  extends IPosComp> IList<RESULT> map(IFun<ITEM, RESULT> f) {
		return this.fold(new MapOp<ITEM, RESULT>(f), new MT<RESULT>());
	}

	@Override
	public <RESULT> RESULT fold(IOp<ITEM, RESULT> f, RESULT e) {
		return this.traverse(new FoldVisitor<RESULT,ITEM>(f,e));
	}

}
