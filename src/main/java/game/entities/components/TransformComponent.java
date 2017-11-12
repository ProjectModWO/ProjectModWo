package game.entities.components;

import lombok.Getter;
import lombok.Setter;
import math.Vector2d;

import java.io.Serializable;

/*
 * 
 *  Position and Rotation of an Object
 *  
 */

@Getter
@Setter
public class TransformComponent implements Serializable{
	
	private Vector2d position;
	
	private Double rotation;
	
	public TransformComponent() {
		
		this(new Vector2d(0, 0), 0D);
	}
	
	public TransformComponent(Vector2d position, Double rotation) {
		
		this.position = position;
		
		this.rotation = rotation;
	}

}
