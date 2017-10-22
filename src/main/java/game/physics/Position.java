package game.physics;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Position {

	private double x;
	private double y;
	private double rotation;
	
	public Position(int x, int y) {
		
		this.x = x;
		this.y = y;
	}

}
