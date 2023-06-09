package snake;

import geometry.Posn;

//上方向 (0,-1) に対応するクラス。
public class DirUp implements IDirection {

	public Posn dirToPosn() {
		return new Posn(0,-1);
	}
	
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null) return false;
	    if (getClass() != obj.getClass()) return false;
	    return true;
	  }
}
