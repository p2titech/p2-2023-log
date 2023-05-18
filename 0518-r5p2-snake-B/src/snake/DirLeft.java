package snake;

import geometry.Posn;

//左方向 (-1,0) に対応するクラス。
public class DirLeft implements IDirection {

	public Posn dirToPosn() {
		return new Posn(-1,0);
	}
	
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null) return false;
	    if (getClass() != obj.getClass()) return false;
	    return true;
	  }


}
