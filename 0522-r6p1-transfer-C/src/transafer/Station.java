package transafer;

public class Station {
	String name;
	Line line;
	
	public Station(String name, Line line) {
		super();
		this.name = name;
		this.line = line;
		this.line.addLine(this);
	}

}
