package transfer;

public class Station implements IStation {
	String name;
	IStation right = new MTStation();
	IStation left = new MTStation();
	public Station(String name) {
		super();
		this.name = name;
	}
	
	public void connectToLeft(Station s) {
		this.left = s;
		s.right = this;
	}
	
	//終着駅を出力する
	public Station getDirection() {
		return null;
	}
}
