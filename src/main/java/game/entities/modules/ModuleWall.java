package game.entities.modules;

import game.entities.capabilities.modules.IModule;
import game.entities.components.PhysicsComponent;
import game.entities.components.TransformComponent;
import math.Vector2d;

public class ModuleWall extends ModuleBase {

	public ModuleWall(IModule parent, TransformComponent transform, PhysicsComponent physics, double weight, double powerConsumption) {
		super(parent, transform, physics, weight, powerConsumption);
		// TODO Auto-generated constructor stub
	}

}
