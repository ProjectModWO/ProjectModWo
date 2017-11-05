package game.entities.modules;

import game.entities.capabilities.ITickable;
import game.entities.components.PhysicsComponent;
import game.entities.components.TransformComponent;
import math.Vector2f;

public class ModuleCore extends ModuleBase implements ITickable{

	private static final double WEIGHT = 1.0D;
	private static final double BASE_POWER_CONSUMPTION = 1.0D;
	
	private double totalPowerConsumption;
	private double maxPower;
	private double storedPower;
	
	private Vector2f relativeCenterOfGravity;

	public ModuleCore(TransformComponent transform, PhysicsComponent physics) {
		super(null, transform, physics, WEIGHT, BASE_POWER_CONSUMPTION);
		this.storedPower = 50000; //TODO read from configuration file
		this.maxPower = 50000; //TODO read from configuration file
		onModuleChange();
	}
	
	@Override
	public void applyForce(Vector2f force, Vector2f pos) {
		//TODO
	}
	
	@Override 
	public void onModuleChange(){
		totalPowerConsumption = getEnergyConsumption();
		relativeCenterOfGravity = centerOfGravity().subtract(getTransform().getPosition());
	}
	
	@Override
	public void destroy() {
		//TODO Handling
		System.err.println("YOU ARE DEAD");
	}

	@Override
	public void tick() {
		storedPower = Math.min(storedPower - totalPowerConsumption, maxPower);
		if (storedPower <= 0) destroy();
		
	}


}
