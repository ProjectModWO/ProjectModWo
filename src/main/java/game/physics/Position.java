package game.physics;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Position {

	private double x;
	private double y;
	private double rotation;
	
	public static final Position ORIGIN = new Position(0, 0);
	
	/**
	 * Creates a new Position object
	 * @param x X-Position
	 * @param y Y-Position
	 */
	public Position(int x, int y) {
		this(x, y, 0D);
	}

	/**
	 * Creates a new Position object
	 * @param x X-Position
	 * @param y Y-Position
	 * @param rotation the Position's rotation (in Rad)
	 */
	
	public Position(double x, double y, double rotation) {
		this.x = x;
		this.y = y;
		this.rotation = rotation;
	}
	
	public void setRotation(double rotation) {
		while(rotation >= Math.PI * 2) {
			rotation -= Math.PI * 2;
		}
		
		while (rotation < 0) {
			rotation += Math.PI * 2;
		}
		this.rotation = rotation;
	}

}
