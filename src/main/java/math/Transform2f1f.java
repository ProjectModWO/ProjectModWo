package math;

import lombok.Getter;
import lombok.Setter;
import math.Vector2f;

/*
 * 
 *  Position and Rotation of an Object
 *  
 */

@Getter
@Setter
public class Transform2f1f{
	
	private Vector2f position;
	
	private float rotation;
	
	public Transform2f1f() {
		
		this(new Vector2f(0, 0), 0f);
	}
	
	public Transform2f1f(Vector2f position, float rotation) {
		
		this.position = position;
		
		this.rotation = rotation;
	}

}
