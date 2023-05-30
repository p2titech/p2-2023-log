package snake;

public interface IListVisitor<RESULT, ELEMENT> {
	RESULT visitCons(Cons<ELEMENT> v);
	RESULT visitMT(MT<ELEMENT> v);
}
