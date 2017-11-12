package game.physics;

import math.Polygon;
import math.Vector2d;

import java.io.Serializable;

public class Hitbox extends Polygon implements Serializable{

	public Hitbox(Vector2d[] points) {
		super(points);
		// TODO Auto-generated constructor stub
	}

	public boolean isColliding(Hitbox another){

		//Todo implement collision
		return false;
	}

}
