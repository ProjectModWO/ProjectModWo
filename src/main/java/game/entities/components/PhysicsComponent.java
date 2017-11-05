package game.entities.components;

import game.physics.Hitbox;
import lombok.Getter;
import lombok.Setter;
import math.Vector2f;

import java.io.Serializable;


/**
 * handle for all physical data for an object
 */
@Getter
@Setter
public class PhysicsComponent implements Serializable{

	private Hitbox hitbox;

	private Vector2f speed;
	private Vector2f accelleration;
	private double mass;

	public PhysicsComponent(Hitbox hitbox, Vector2f speed, Vector2f accelleration, double mass) {
		this.hitbox = hitbox;
		this.speed = speed;
		this.accelleration = accelleration;
		this.mass = mass;
	}

	public double getWeight() {
		return mass;
	}

	public Vector2f getSpeed() {
		return speed;
	}

	public Vector2f getAcceleration() {
		return accelleration;
	}

	public Vector2f getImpulse() {
		return speed.multiply(mass);
	}
}
