package snake;

public class FoldVisitor<RESULT,ITEM> implements IListVisitor<RESULT,ITEM> {
	
	private IOp<ITEM, RESULT> f;
	private RESULT e;

	public FoldVisitor(IOp<ITEM, RESULT> f, RESULT e) {
		this.f = f;
		this.e = e;
	}

	@Override
	public RESULT visitCons(Cons<ITEM> v) {
		return this.f.combine(
				v.fst, 
				v.rst.traverse(this));
	}

	@Override
	public RESULT visitMT(MT<ITEM> v) {
		return this.e;
	}


}
