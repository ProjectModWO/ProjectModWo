package game.entities.modules;

import game.math.Position;
import game.math.Vector;

public class ModuleHangar extends ModuleBase {

	public ModuleHangar(IModule parent, Position pos, double weight, double powerConsumption) {
		super(parent, pos, weight, powerConsumption);
		// TODO Auto-generated constructor stub
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

}
