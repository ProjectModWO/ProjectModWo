package game.physics;

import game.math.Polygon;
import game.math.Vector;

import java.io.Serializable;

public class Hitbox extends Polygon implements Serializable{

	public Hitbox(Vector[] points) {
		super(points);
		// TODO Auto-generated constructor stub
	}

	public boolean isColliding(Hitbox another){

		//Todo implement collision
		return false;
	}

}
