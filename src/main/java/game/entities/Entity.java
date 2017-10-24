package game.entities;

import game.entities.capabilities.IMovable;
import game.physics.Position;
import game.utils.Vector;

public abstract class Entity implements IMovable{

    public abstract Position getPosition();
    public double weight;
    public Vector speed;
    
	@Override
	public double getWeight() {
		return weight;
	}

	@Override
	public Vector getSpeed() {
		return speed;
	}

	@Override
	public Vector getAcceleration() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void move(Vector impulse) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move(Vector force, double timeInMillis) {
		// TODO Auto-generated method stub
		
	}

}
