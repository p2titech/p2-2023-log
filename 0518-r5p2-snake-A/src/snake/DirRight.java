package snake;

import geometry.Posn;

//右方向 (1,0) に対応するクラス。
public class DirRight implements IDirection {
	
	public Posn dirToPosn() {
		return new Posn(1,0);
	}
	
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null) return false;
	    if (getClass() != obj.getClass()) return false;
	    return true;
	  }
}
