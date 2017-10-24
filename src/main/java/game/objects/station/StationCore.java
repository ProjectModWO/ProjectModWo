package game.objects.station;

import game.entities.capabilities.IRenderable;

import java.awt.image.BufferedImage;

import game.entities.capabilities.ICanMove;
import game.physics.Position;
import game.utils.Vector;
import lombok.Getter;

public class StationCore implements ICanMove, IRenderable{

	private static final double WEIGHT = 1.0D;
	
	private static Position pos;
	
	public StationCore(Position pos) {
		this.pos = pos;
	}
	
	
	@Override
	public double getWeight() {
		return WEIGHT;
	}

	@Override
	public Vector getSpeed() {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public void move(Position target) {
		// TODO Auto-generated method stub
		
		
	}


	@Override
	public BufferedImage getImage() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Position getPosition() {
		return pos;
	}

}
