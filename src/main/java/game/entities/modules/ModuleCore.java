package game.entities.modules;

import game.math.Position;
import game.math.Vector;

public class ModuleCore extends ModuleBase{

	private static final double WEIGHT = 1.0D;
	private static final double BASE_POWER_CONSUMPTION = 1.0D;
	
	private Position relativeCenterOfGravity;
	
	private static Position pos;
	
	public ModuleCore(Position pos) {
		super(null, pos, WEIGHT, BASE_POWER_CONSUMPTION);
	}
	
	@Override
	public void applyForce(Vector force, Position pos) {
		//TODO calculate movement/rotation/...
	}
	
	@Override 
	public void onModuleChange(){
		relativeCenterOfGravity = new Position(centerOfGravity().asVector().subtract(pos.asVector()));
	}
	

}
