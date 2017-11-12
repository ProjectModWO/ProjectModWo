package game.entities.modules;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import game.entities.Entity;
import game.entities.capabilities.modules.IModule;
import game.entities.components.PhysicsComponent;
import game.entities.components.TransformComponent;
import math.Vector2d;

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
	public void applyForce(Vector2d force) {
		parent.applyForce(force, getTransform().getPosition());
	}
	
	@Override
	public void applyForce(Vector2d force, Vector2d pos) {
		parent.applyForce(force, pos);
	}
	
	@Override
	public Vector2d centerOfGravity() {
		Vector2d v = getTransform().getPosition() * getPhyComp().getWeight();
		
		for(IModule module : connectedModules) {
			Vector2d relPos = module.centerOfGravity();
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
	public void move(Vector2d impulse) {

	}

	@Override
	public void move(Vector2d force, double timeInMillis) {

	}

	@Override
	public Vector2d getImpulse() {
		return getPhyComp().getImpulse();
	}

	@Override
	public void execute(byte ident, Serializable... args) {
		// TODO Auto-generated method stub
		
	}
}
