package game.entities.modules;

import java.util.LinkedList;
import java.util.List;

import game.entities.Entity;
import game.entities.capabilities.modules.IModule;
import game.entities.components.PhysicsComponent;
import game.entities.components.TransformComponent;
import game.math.Vector2f;

public class ModuleBase extends Entity implements IModule {

	private List<IModule> connectedModules = new LinkedList<>();
	private IModule parent;
	private double powerConsumption;
	
	
	public ModuleBase(IModule parent, TransformComponent transform, PhysicsComponent physics, double weight, double powerConsumption) {
		super(transform, physics);
		this.parent = parent;
		this.powerConsumption = powerConsumption;
		if(parent != null) parent.addConnectedModule(this);
	}
	
	@Override
	public List<IModule> getConnectedModules() {
		return connectedModules;
	}

	@Override
	public IModule getParent() {
		return parent;
	}

	@Override
	public double getEnergyConsumption() {
		double energy = powerConsumption;
		for (IModule module : connectedModules) {
			energy += module.getEnergyConsumption();
		}
		return energy;
	}
	
	@Override
	public void applyForce(Vector2f force) {
		parent.applyForce(force, getTransform().getPosition());
	}
	
	@Override
	public void applyForce(Vector2f force, Vector2f pos) {
		parent.applyForce(force, pos);
	}
	
	@Override
	public Vector2f centerOfGravity() {
		Vector2f v = getTransform().getPosition() * getPhyComp().getWeight();
		
		for(IModule module : connectedModules) {
			Vector2f relPos = module.centerOfGravity();
			double branchMass = module.branchMass();
			v = v + (relPos * branchMass);
		}
		
		return v / branchMass();
	}
	
	public double branchMass() {
		
		double toReturn = getPhyComp().getWeight();
		for(IModule module : connectedModules) {
			toReturn += module.branchMass();
		}
		return toReturn;
	}
	
	public void onModuleChange() {
		parent.onModuleChange();
	}
	
	@Override
	public void addConnectedModule(IModule toAdd) {
		connectedModules.add(toAdd);
	}
	
	@Override
	public void removeConnectedModule(IModule toRemove) {
		connectedModules.remove(toRemove);
	}
	
	@Override
	public void destroy() {
		parent.removeConnectedModule(this);
		onModuleChange();
	}


	@Override
	public void move(Vector2f impulse) {

	}

	@Override
	public void move(Vector2f force, double timeInMillis) {

	}

	@Override
	public Vector2f getImpulse() {
		return getPhyComp().getImpulse();
	}
}
