package snake;

public class Cons<ITEM> extends AList<ITEM> {
	ITEM fst;
	IList<ITEM> rst;

	public Cons(ITEM fst, IList<ITEM> rst) {
		super();
		this.fst = fst;
		this.rst = rst;
	}
	
	@Override
	public <RESULT> RESULT traverse(IListVisitor<RESULT, ITEM> v) {
		return v.visitCons(this);
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fst == null) ? 0 : fst.hashCode());
		result = prime * result + ((rst == null) ? 0 : rst.hashCode());
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
		Cons other = (Cons) obj;
		if (fst == null) {
			if (other.fst != null)
				return false;
		} else if (!fst.equals(other.fst))
			return false;
		if (rst == null) {
			if (other.rst != null)
				return false;
		} else if (!rst.equals(other.rst))
			return false;
		return true;
	}




		
}
