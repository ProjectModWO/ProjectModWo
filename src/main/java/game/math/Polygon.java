package game.math;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/*
 * 
 * 	Simple Polygon object
 * 
 */

@Getter
@Setter
public class Polygon implements Serializable{

	private Vector[] points;
	
	public Polygon(Vector[] points) {
		
		this.points = points;
	}

}
