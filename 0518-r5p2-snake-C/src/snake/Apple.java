package snake;

import geometry.*;

import java.util.Objects;

import colors.*;

//リンゴ１個のデータ
public class Apple {
	Posn location;
	IColor appleColor = new Red();
	
	public Apple(Posn location) {
		this.location = location;
	}

	@Override
	public int hashCode() {
		return Objects.hash(appleColor, location);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Apple other = (Apple) obj;
		return Objects.equals(appleColor, other.appleColor) && Objects.equals(location, other.location);
	}
	
}
