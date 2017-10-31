package game.entities.components;

import game.math.Vector;
import game.physics.Hitbox;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


/**
 * handle for all physical data for an object
 */
@Getter
@Setter
public class PhysicsComponent implements Serializable{

	private Hitbox hitbox;

	private Vector speed;
	private Vector accelleration;
	private double mass;

	public PhysicsComponent(Hitbox hitbox, Vector speed, Vector accelleration, double mass) {
		this.hitbox = hitbox;
		this.speed = speed;
		this.accelleration = accelleration;
		this.mass = mass;
	}

	public double getWeight() {
		return mass;
	}

	public Vector getSpeed() {
		return speed;
	}

	public Vector getAcceleration() {
		return accelleration;
	}

	public Vector getImpulse() {
		return speed.multiply(mass);
	}
}
