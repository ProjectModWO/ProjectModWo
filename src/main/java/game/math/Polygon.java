package game.math;

import lombok.Getter;
import lombok.Setter;

/*
 * 
 * 	Simple Polygon object
 * 
 */

@Getter
@Setter
public class Polygon {

	private Vector[] points;
	
	public Polygon(Vector[] points) {
		
		this.points = points;
	}

}
