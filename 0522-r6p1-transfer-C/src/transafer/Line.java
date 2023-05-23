package transafer;

public class Line {
	ILines l = new MTLines();

	public Line() {
		super();
	}
	
	void addLine(Station that) {
		this.l = new ConsLines(that, this.l);
	}
}
