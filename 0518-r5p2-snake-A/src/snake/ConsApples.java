package snake;

import java.util.Objects;

import draw.Canvas;

//リンゴのリストにリンゴを1個加えたもの
public class ConsApples implements IApples {
	Apple fst;
	IApples rst;
	
	public ConsApples(Apple fst, IApples rst) {
		this.fst = fst;
		this.rst = rst;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConsApples other = (ConsApples) obj;
		return Objects.equals(fst, other.fst) && Objects.equals(rst, other.rst);
	}

	@Override
	public boolean draw(Canvas c) {
		// TODO Auto-generated method stub
		
		return this.fst.draw(c) && this.rst.draw(c);
	}

}
