package transafer;

public class ConsStations implements IStations {
	String name;
	IStations pre;
	IStations post = new MTStations();
	
	public ConsStations(String name, IStations pre) {
		super();
		this.name = name;
		this.pre = pre;
		pre.assignPost(this);
	}
	//postを割り当てる
	public void assignPost(ConsStations sta) {
		this.post=sta;
	};
	public String direction(String des) {
		
	};
	public boolean isTherePost(String des) {
		if(this.name == des) {
			return true;
		}
		else {
			return this.post.isTherePost(des);
		}
	}
	public boolean isTherePre(String des) {	
		if(this.name == des) {
		return true;
	}
		else {
			return this.pre.isTherePre(des);
		}
	}
}
// (=^ω^=) < meow