package snake;

//リンゴの空リスト
public class MTApples implements IApples {
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null) return false;
	    if (getClass() != obj.getClass()) return false;
	    return true;
	  }
}
