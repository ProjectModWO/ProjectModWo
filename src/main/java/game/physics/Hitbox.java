package game.physics;

import math.Polygon;
import math.Vector2f;

import java.io.Serializable;

public class Hitbox extends Polygon implements Serializable{

	public Hitbox(Vector2f[] points) {
		super(points);
		// TODO Auto-generated constructor stub
	}

	public boolean isColliding(Hitbox another){

		//Todo implement collision
		return false;
	}

}
