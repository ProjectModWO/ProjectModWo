package game.entities.components;

import game.math.Vector;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/*
 * 
 *  Position and Rotation of an Object
 *  
 */

@Getter
@Setter
public class TransformComponent implements Serializable{
	
	private Vector position;
	
	private Double rotation;
	
	public TransformComponent() {
		
		this(new Vector(0, 0), 0D);
	}
	
	public TransformComponent(Vector position, Double rotation) {
		
		this.position = position;
		
		this.rotation = rotation;
	}

}
