package game.entities.components;

import game.math.Vector;
import game.physics.Hitbox;
import lombok.Getter;
import lombok.Setter;

/*
 * 
 *	Weight, Speed and Hitbox of an Object
 * 
 */

@Getter
@Setter
public class PhysicsComponent {
	
	private Double weight;
	
	private Vector speed;
	
	private Hitbox hitbox;
	
	public PhysicsComponent(Double weight, Vector speed, Hitbox hitbox) {
		
		this.weight = weight;
		this.speed = speed;
		this.hitbox = hitbox;
	}

}
