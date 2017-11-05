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

	private Vector2f[] points;
	
	public Polygon(Vector2f[] points) {
		
		this.points = points;
	}

}
