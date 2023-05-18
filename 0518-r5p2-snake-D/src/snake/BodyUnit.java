package snake;

import java.util.Objects;

import colors.*;
import draw.Canvas;
import geometry.*;

// a body unit of a snake
public class BodyUnit {
	Posn location;
	IColor bodyColor = new Green();
	
	public BodyUnit(Posn location) {
		this.location = location;
	}
	
	public Posn getLocation() {
		return this.location;
	}
	
	public BodyUnit move(Posn newLocation) {
		return new BodyUnit(newLocation);
	}	
	
	//蛇の体節の描画：簡単のため描画サイズ固定
	public boolean draw(Canvas c) {
		return c.drawDisk(new Posn(this.location.getX()*30 + 45, this.location.getY()*30 + 45),15,this.bodyColor);
		
	}
	
	// to test whether the body unit is located at loc
	public boolean isLocated(Posn loc) {
		return loc.equals(this.location);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BodyUnit other = (BodyUnit) obj;
		return Objects.equals(bodyColor, other.bodyColor) && Objects.equals(location, other.location);
	}
}
