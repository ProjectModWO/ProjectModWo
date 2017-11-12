package math;

import lombok.Getter;
import lombok.Setter;
import math.Vector2d;

/*
 * 
 *  Position and Rotation of an Object
 *  
 */

@Getter
@Setter
public class Transform2d1d{
	
	private Vector2d position;
	
	private Double rotation;
	
	public Transform2d1d() {
		
		this(new Vector2d(0, 0), 0D);
	}
	
	public Transform2d1d(Vector2d position, Double rotation) {
		
		this.position = position;
		
		this.rotation = rotation;
	}

}
