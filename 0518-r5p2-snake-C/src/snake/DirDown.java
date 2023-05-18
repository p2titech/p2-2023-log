package snake;

import geometry.Posn;

//下方向 (1,0) に対応するクラス。
public class DirDown implements IDirection {
	
	public Posn dirToPosn() {
		return new Posn(0,1);
	}
	
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null) return false;
	    if (getClass() != obj.getClass()) return false;
	    return true;
	  }


	
} 