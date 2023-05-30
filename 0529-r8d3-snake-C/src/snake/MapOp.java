package snake;

public class MapOp<ITEM,RESULT> implements IOp<ITEM,IList<RESULT>> {

	private IFun<ITEM, RESULT> f;

	public MapOp(IFun<ITEM, RESULT> f) {
		this.f = f;
	}

	@Override
	public IList<RESULT> combine(ITEM x, IList<RESULT> y) {
		return new Cons<RESULT>(this.f.process(x), y);
	}


}
