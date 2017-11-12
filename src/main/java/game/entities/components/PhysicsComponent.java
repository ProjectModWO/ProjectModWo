package game.entities.components;

import game.physics.Hitbox;
import lombok.Getter;
import lombok.Setter;
import math.Vector2d;

import java.io.Serializable;


/**
 * handle for all physical data for an object
 */
@Getter
@Setter
public class PhysicsComponent implements Serializable{

	private Hitbox hitbox;

	private Vector2d speed;
	private Vector2d accelleration;
	private double mass;

	public PhysicsComponent(Hitbox hitbox, Vector2d speed, Vector2d accelleration, double mass) {
		this.hitbox = hitbox;
		this.speed = speed;
		this.accelleration = accelleration;
		this.mass = mass;
	}

	public double getWeight() {
		return mass;
	}

	public Vector2d getSpeed() {
		return speed;
	}

	public Vector2d getAcceleration() {
		return accelleration;
	}

	public Vector2d getImpulse() {
		return speed.multiply(mass);
	}
}
