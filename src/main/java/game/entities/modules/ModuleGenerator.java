package game.entities.modules;

import game.entities.capabilities.modules.IModule;
import game.entities.components.PhysicsComponent;
import game.entities.components.TransformComponent;

public class ModuleGenerator extends ModuleBase {

	public ModuleGenerator(IModule parent, TransformComponent transform, PhysicsComponent physics, double weight, double powerConsumption) {
		super(parent, transform, physics, weight, powerConsumption);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onModuleChange() {
		// TODO Auto-generated method stub
		
	}

}
