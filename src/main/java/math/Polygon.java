package math;

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

	private Vector2d[] points;
	
	public Polygon(Vector2d[] points) {
		
		this.points = points;
	}

}
