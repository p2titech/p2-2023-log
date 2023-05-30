package snake;

public class MT<ITEM extends IGameObject> extends AList<ITEM> {
	
	MT() {} 
	
	@Override
	public <RESULT> RESULT traverse(IListVisitor<RESULT, ITEM> v) {
		return v.visitMT(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	@Override
	public <RESULT extends IGameObject> IList<RESULT> map(IFun<ITEM, RESULT> f) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <RESULT> RESULT fold(IOp<ITEM, RESULT> f, RESULT e) {
		// TODO Auto-generated method stub
		return null;
	}
}
