package transafer;

public class ConsLines implements ILines {
	Station first;
	ILines rest;
	public ConsLines(Station first, ILines rest) {
		super();
		this.first = first;
		this.rest = rest;
	}
	

}
