package game.entities.modules;

import game.entities.components.PhysicsComponent;
import game.entities.components.TransformComponent;
import game.math.Vector;

public class ModuleCore extends ModuleBase{

	private static final double WEIGHT = 1.0D;
	private static final double BASE_POWER_CONSUMPTION = 1.0D;
	
	private Vector relativeCenterOfGravity;
	
	public ModuleCore(TransformComponent transform, PhysicsComponent physics) {
		super(null, transform, physics, WEIGHT, BASE_POWER_CONSUMPTION);
	}
	
	@Override
	public void applyForce(Vector force, Vector pos) {
		
	}
	
	@Override 
	public void onModuleChange(){
		relativeCenterOfGravity = centerOfGravity().subtract(getTransform().getPosition());
	}
	
	@Override
	public void destroy() {
		//TODO Handling
		System.err.println("YOU ARE DEAD");
	}


}
